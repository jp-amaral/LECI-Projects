from enum import Flag
from logging import log
from sys import meta_path
from flask import Flask, render_template, url_for, redirect, request, session
from hashlib import md5
import sqlite3 as sql
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms
import socket, requests, os, json, re
import time

app = Flask(__name__)
app.config['DEBUG'] = True
app.config['TEMPLATES_AUTO_RELOAD'] = True
app.secret_key = 'project2_25_safe'

PATH = os.path.dirname(os.path.abspath(__file__))

con = sql.connect('uap.db', check_same_thread=False)

C = 0x01
R = 0x02
S = 0x03
F = 0x04

def tobits(s):
    result = []
    for c in s:
        bits = bin(ord(c))[2:]
        bits = '00000000'[len(bits):] + bits
        result.extend([int(b) for b in bits])
    return result

def frombits(bits):
    chars = []
    for b in range(int(len(bits) / 8)):
        byte = bits[b*8:(b+1)*8]
        chars.append(chr(int(''.join([str(bit) for bit in byte]), 2)))
    return ''.join(chars)

@app.route('/authentication', methods=['GET', 'POST'])
def authentication():
    if 'loggedin' in session:
        username = request.form['username']
        source = request.form['source']
        print("Connecting to server")
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.connect(('127.0.0.1', 5005))
        print("Connected")
        aux = session['iv']
        iv = aux[:16]
        data = readJSON(session['username'], iv)
        writeJSON(data, session['username'],iv)
        
        #Sending username to given DNS

        for ids in range(1,int(data[source]['total_accounts'])+1):
            if data[source][str(ids)]['username'] == username:
                password = data[source][str(ids)]['password']
                break

        s.send(username.encode())

        #Getting challenge and salt
        reply = s.recv(2048)
 
        data = json.loads(reply.decode())
        challenge = data.get("challenge")
        challenge = challenge[2:-1]
        challenge = challenge.replace('\\\\', '\\')
        challenge = challenge.replace("'", "")
        challenge = challenge.replace('"', "")
        challenge = challenge.encode()

        salt = data.get("salt")
        salt = salt[2:-1]
        salt = salt.replace('\\\\', '\\')
        salt = str.encode(salt)

        #encoding password
        password = md5(password.encode()+salt).hexdigest()

        #response to challenge
        response = md5(password.encode()+challenge).hexdigest()
        response_bits = tobits(response)

        for i in range(100):
            s.send(str(response_bits[i]).encode())
            time.sleep(0.01)

        status = s.recv(1024).decode()
        
        if(status == "OK"):
            s.close()
            print("OK")
            print("Disconnected")
            return redirect(url_for('redirecting', source=source, user=username))
        else:
            s.close()
            print(status)
            print("Disconnected")
            return redirect(url_for('add_entry', error="Failed to authenticate, add new entry"))
    else:
        return redirect(url_for('main'))
   
@app.route('/redirecting', methods=['GET', 'POST'])
def redirecting():
    source = request.args.get("source")
    user = request.args.get("user")
    return render_template('redirect.html', source=source, user=user)

def generateKey(password, salt):
    kdf = PBKDF2HMAC(
        algorithm=hashes.SHA256(),
        length=32,
        salt=salt,
        iterations=100000
    )
    key = kdf.derive(password.encode())
    key = key[:64]
    return key

def decrypt(data, key, iv):
    cipher = Cipher(algorithms.ChaCha20(key, iv), mode=None)
    decryptor = cipher.decryptor()
    decrypted_data = decryptor.update(data) + decryptor.finalize()
    return decrypted_data

def encrypt(data, key, iv):
    cipher = Cipher(algorithms.ChaCha20(key, iv), mode=None)
    encryptor = cipher.encryptor()
    encrypted_data = encryptor.update(data) + encryptor.finalize()
    return encrypted_data

def writeJSON(data,ficheiro, iv):
    #geraçao da key
    username = session['username']
    query = f"SELECT * FROM users WHERE username = '{username}' "
    cursor = con.cursor()
    cursor.execute(query)
    account = cursor.fetchone()

    salt = account[3] 
    salt_final = str.encode(salt) 
    password = account[2]
    
    key = generateKey(password, salt_final)
    #fim da geraçao de key

    #Primeiro: escrever no ficheiro como json
    with open(f'./APP/uap_users/{ficheiro}.json','w+') as f:
        json.dump(data,f)
    f.close()

    #Segundo: ler o ficheiro
    with open(f'./APP/uap_users/{ficheiro}.json', 'rb') as f:
        data = f.read()
    f.close()

    #Terceiro: encriptar o ficheiro
    encrypted_data = encrypt(data, key, iv)
    
    with open(f'./APP/uap_users/{ficheiro}.json', 'wb') as f:
        f.write(iv)
        f.write(encrypted_data)
    f.close()

def readJSON(ficheiro, iv):
    #geraçao da key
    username = session['username']
    query = f"SELECT * FROM users WHERE username = '{username}' "
    cursor = con.cursor()
    cursor.execute(query)
    account = cursor.fetchone()

    salt = account[3] 
    salt_final = str.encode(salt)
    password = account[2]
    
    key = generateKey(password, salt_final)
    #fim da geraçao de key

    if os.path.isfile(f'./APP/uap_users/{ficheiro}.json') == False:
        aux = {}
        writeJSON(aux,ficheiro, iv)

    #Primeiro: desencriptar o ficheiro
    with open(f'./APP/uap_users/{ficheiro}.json', 'rb') as f:    
        iv = f.read(16)
        data = f.read()
    f.close()

    decrypted_data = decrypt(data, key, iv)

    with open(f'./APP/uap_users/{ficheiro}.json', 'wb') as output_file:
        output_file.write(decrypted_data)
    output_file.close()

    #Segundo: ler o ficheiro como json
    with open(f'./APP/uap_users/{ficheiro}.json') as f:
        return json.load(f)

@app.route('/', methods=['GET', 'POST'])
def main():
    username = ""
    if 'loggedin' in session:
        username = session['username']
        return render_template('UAP_main_logged_in.html', user=username)
    else:
        return render_template('UAP_main.html',user="")


@app.route('/print_json',methods=['GET', 'POST'])
def print_json():
    try:
        aux = session['iv']
        iv = aux[:16]
        data = readJSON(session['username'], iv)
        print(data)
        writeJSON(data, session['username'],iv)
        return redirect(url_for('main'))
    except:
        return redirect(url_for('main'))

@app.route('/profile',methods=['GET', 'POST'])
def profile():
    if 'loggedin' in session:
        try:
            error = request.args.get("error")
        except:
            error = ""
        if error==None: error=""  
        return render_template('UAP_profile.html',user=session['username'], error=error)
    else:
        return redirect(url_for('login', error="Must be logged in"))

@app.route('/dinamicprofile',methods=['GET', 'POST'])
def dinamicprofile():
    if not 'loggedin' in session:
        return redirect(url_for('login', error="Must be logged in"))

    if os.path.isfile(f"./APP/uap_users/{session['username']}.json") == False:
        file = open("APP/templates/UAP_profile_static.html", 'r', encoding="utf8").read()
        file_string = str(file)
        file = open("APP/templates/UAP_profile.html","w", encoding="utf-8")
        file.write(file_string)
        return redirect(url_for('profile', error="There are no accounts yet"))

    file = open("APP/templates/UAP_profile_static.html", 'r', encoding="utf8").read()
    file_string = str(file)
    spot = "<!--INSERT HERE-->"
    stop = file_string.find(spot)
    aux = session['iv']
    iv = aux[:16]
    data = readJSON(session['username'], iv)
    writeJSON(data, session['username'],iv)
    info = ""
    
    for source in data.keys(): 
        info += "<table class=\"center container2\"><tr><th class=\"container3\">" + source + "</th></tr><tr>"
        for ids in range(1,int(data[source]['total_accounts'])+1):
            username = data[source][str(ids)]['username']
            info +="<tr><td>"+ username +"</td></tr>"
        info += "</tr></table>"
    
    final = file_string[:stop + len(spot)] + info + file_string[stop + len(spot):]
    file = open("APP/templates/UAP_profile.html","w", encoding="utf-8")
    file.write(final)
    return redirect(url_for('profile'))
    
@app.route('/logout',methods=['GET', 'POST'])
def logout():
    if 'loggedin' in session:
        session.pop('loggedin', None)
        session.pop('id', None)
        session.pop('username', None)
        session.pop('iv', None)
        return redirect(url_for('main'))

    return redirect(url_for('main'))


@app.route('/login', methods=['GET','POST'])
def login():
    source ="UAP"
    if request.method == 'POST' and 'ip' in request.form:
        source = request.form['ip']
        print("who called me: ",source)

    try:
        error = request.args.get("error")
    except:
        error = ""
    if error == None: error = ""

    if request.method == 'POST' and 'username' in request.form and 'password' in request.form:
        username = request.form['username']
        login = request.form['login']
        print(login)
        ##protecao contra SQL injection
        #------------------------------
        if not re.match(r'[A-Za-z0-9_.]+', username):
            return redirect(url_for('login', error="Wrong credentials"))
        #------------------------------
        password = request.form['password']
        source = request.form['source']

        cursor = con.cursor()

        query = f"SELECT * FROM users WHERE username = '{username}' "
        cursor.execute(query)
        account = cursor.fetchone()
        if account:
            salt = account[3] 
            salt_final = str.encode(salt)
        else:
            return redirect(url_for('login', error="Wrong credentials"))

        password_aux = md5(password.encode()).hexdigest()
        query = f"SELECT * FROM users WHERE username = '{username}' and password = '{md5(password_aux.encode()+salt_final).hexdigest()}'"
        cursor.execute(query)
        account = cursor.fetchone()
        if account:
            #LOGIN SUCCESSFULL
            session['loggedin'] = True
            session['id'] = account[0]
            session['username'] = account[1]
            iv = account[4]
            session['iv'] = str.encode(iv)

            #START AUTHENTICATION PROCESS
            if source != "UAP":
                return redirect(url_for('select_user', source=source))
            else:
                return redirect(url_for('main'))
        else:
            return render_template('UAP_login.html', source = source, error = error)
    else:
        return render_template('UAP_login.html', source = source, error = error)

@app.route('/select_user', methods=['GET', 'POST'] )
def select_user():
    if 'loggedin' in session:
        source = request.args.get("source")
        file = open("APP/templates/UAP_select_user_static.html", 'r', encoding="utf8").read()
        file_string = str(file)
        spot = "<!--INSERT HERE-->"
        stop = file_string.find(spot)
        aux = session['iv']
        iv = aux[:16]
        data = readJSON(session['username'], iv)
        writeJSON(data, session['username'],iv)
        users = []
        try:
            for ids in range(1,int(data[source]['total_accounts'])+1):
                username = data[source][str(ids)]['username']
                users += [username]
        except:
            #Conta com domain nao existe
            return redirect(url_for('add_entry', error="No account found to given domain"))
        info =""
        for i in users:
            info += '''<form action="{{url_for('authentication')}}" method="post"><span><input type="text" name="source" value="'''+source+'''"hidden><input type="submit" name="username" value="'''+str(i)+'''" style="cursor: pointer;" readonly><input type="hidden" name="source" value="'''+source+'''"></span></form>'''
        final = file_string[:stop + len(spot)] + info + file_string[stop + len(spot):]
        file = open("APP/templates/UAP_select_user.html","w", encoding="utf-8")
        file.write(final)
        #print("renderizou o template ya")
        return redirect(url_for('open_select_user', source=source))
    else:
        return redirect(url_for('main'))

@app.route('/open_select_user', methods=['GET', 'POST'])
def open_select_user():
    return render_template('UAP_select_user.html', user=session['username'], domain=request.args.get("source"))

@app.route('/register', methods=['GET', 'POST'])
def register():
    if request.method == 'POST' and 'username' in request.form:
        print("form")
        password1 = request.form['password1']
        password2 = request.form['password2']
        if password1 != password2:
            print("diferent passwords")
            return render_template('UAP_register.html',error="Password not match")
        username = request.form['username']
        #----------------------------------------------
        if not re.match(r'[A-Za-z0-9_.]+', username) or not re.match(r'[A-Za-z0-9_.]+', password1):
            print("not allowed")
            return render_template('UAP_register.html')
        #-----------------------------------------------
        
        cursor = con.cursor()
        query = f"SELECT * FROM users WHERE username = '{username}'"
        cursor.execute(query) 
        account = cursor.fetchone()

        if account:
            print("account exists")
            return render_template('UAP_register.html',error="Account already exists")
            
        salt = os.urandom(16)
        print("size of salt", len(salt))
        
        iv = os.urandom(16)
        print("size of iv", len(iv))
        salt = salt.replace(b"'", b'')
        salt = salt.replace(b'"',b'')
        iv = iv.replace(b"'", b'')
        iv = iv.replace(b'"',b'')
        salt2 = str(salt)
        iv2 = str(iv)
        salt_raw = salt2[2:-1]
        iv_raw = iv2[2:-1]
        salt_final = str.encode(salt_raw)
        password_aux = md5(password1.encode()).hexdigest()
        query = f'INSERT INTO users VALUES (NULL,"{username}", "{md5(password_aux.encode()+salt_final).hexdigest()}", "{salt_raw}", "{iv_raw}")' 
        cursor.execute(query)
        con.commit() 
        return redirect(url_for('login', error="Now login to access account"))
        
        

    return render_template('UAP_register.html')
    

@app.route('/add_entry', methods=['GET', 'POST'])
def add_entry():
    try:
        error = request.args.get("error")
    except:
        error = ""
    print(error)
    if error == None: error = ""
    try:
        username = session['username']
        aux = session['iv']
        iv = aux[:16]
    except Exception as e:
        print(e)
        #login to add entry
        return redirect(url_for('login', error ="Login to add entry"))

    if request.method == 'POST' and 'domain' in request.form:
        document_path = os.getcwd()+"/APP/uap_users/"+username+".json"
        

        db = readJSON(username, iv) # read database
        domain_username = request.form['username']
        domain_password = request.form['password']
        domain = request.form['domain']


        ## hash domain_password
        domain_password = md5(domain_password.encode()).hexdigest()
        ##

       
        if domain in db:
            id_nmb = int(db[domain]['total_accounts'])
            change = 1
            for ids in range(1,id_nmb+1,1):
                if domain_username == db[domain][str(ids)]['username'] and domain_password == db[domain][str(ids)]['password']:
                    change = 0
                    break
                elif domain_username == db[domain][str(ids)]['username'] and domain_password != db[domain][str(ids)]['password']:
                    db[domain][str(ids)]['password'] = domain_password
                    change = 0
                    break
            if change == 1:
                id_string = str(id_nmb + 1)
                db[domain][id_string] = {}
                db[domain][id_string]['username'] = domain_username
                db[domain][id_string]['password'] = domain_password
                db[domain]['total_accounts'] = str(id_nmb + 1)

        else:
            aux = {}
            aux['username'] = domain_username
            aux['password'] = domain_password
            db[domain] = {}
            db[domain]['total_accounts'] = 1
            db[domain]['1'] = aux                   # 'id'

        writeJSON(db,username, iv) # write in database


        return redirect(url_for('main'))

    return render_template('UAP_add_entry.html', error=error)


if __name__ == '__main__':
   app.run(port=8080)

