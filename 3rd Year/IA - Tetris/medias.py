class bcolors:
    HEADER = '\033[95m'
    OKBLUE = '\033[94m'
    OKCYAN = '\033[96m'
    OKGREEN = '\033[92m'
    WARNING = '\033[93m'
    FAIL = '\033[91m'
    ENDC = '\033[0m'
    BOLD = '\033[1m'
    UNDERLINE = '\033[4m'
    black = '\033[30m'
    red = '\033[31m'
    green = '\033[32m'
    yellow = '\033[33m'
    blue = '\033[34m'
    magenta = '\033[35m'
    cyan = '\033[36m'
    white = '\033[37m'
# Using readlines()
import os
os.system('clear')
file = open('machinelearning.txt', 'r')
Lines = file.readlines()
output=""
count = 0
save = []
flag = 1
record = 0
print(f"{bcolors.WARNING}--------------------------------------------   MEDIA TETRIS   -------------------------------------------{bcolors.ENDC}")
for line in Lines:
    linhasnumber = line.strip().split(" ")
    lista= [ x for x in linhasnumber if x != '']
    suma=0
    #max = max(linhasnumber)
    for value in lista:
        if value != '':
            #print(f"|{value}|")
            suma+=int(value)
            if record < int(value):
                record = int(value)
            if(int(value) > 6201) and flag:
                os.system('xdg-open http://atnog-tetriscores.av.it.pt/table.html')
                flag=0
    total = suma
    if len(lista) == 10:
        save.append(total)
        cor = bcolors.OKCYAN
    else:
        cor = bcolors.FAIL
    print('{}SOMA[{:2d}]{} =  {}{:5d}{} -> {}{:2d}&{}{}'.format(bcolors.OKGREEN,count,bcolors.ENDC,bcolors.BOLD,total,bcolors.ENDC,cor,len(lista),bcolors.ENDC,lista))
    count+=1
print(f"{bcolors.WARNING}---------------------------------------------------------------------------------------------------------{bcolors.ENDC}")
print(f'{bcolors.HEADER}RECORD{bcolors.ENDC}      - {bcolors.yellow}{record}')
try:
    print(f'{bcolors.HEADER}SOMA MAXIMA{bcolors.ENDC} - {bcolors.OKCYAN}{max(save)}\n{bcolors.HEADER}SOMA MINIMA{bcolors.ENDC} - {bcolors.OKCYAN}{min(save)}{bcolors.ENDC}\n{bcolors.HEADER}SOMA MEDIA{bcolors.ENDC}  - {bcolors.OKCYAN}{int(sum(save)/len(save))}{bcolors.yellow}')
except : pass