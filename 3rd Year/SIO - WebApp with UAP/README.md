# project-2---authentication-equipa_25
project-2---authentication-equipa_25 created by GitHub Classroom

# Instruções de utilização
Na pasta do diretório executar os comandos: <br>
Num terminal:
```bash
$ ./run_uap
```

Num outro terminal:
```bash
$ ./run_uap
```

Contas já existentes na UAP:
<table>
  <thead>
    <th>Username</th>
    <th>Password</th>
  </thead>
  <tbody>
    <tr>
      <td>pedro</td>
      <td>pedro1234</td>
    </tr>
    <tr>
      <td>amaral</td>
      <td>amaral1234</td>
    </tr>
  </tbody>
</table>

# Contribuição
**De salientar que o projeto foi feito recorrendo não só ao <i>Github</i> como plataforma de controlo de versões mas também a sessões de <i>code live share</i>, tendo sido distribuido igualmente entre todos os contribuidores.**
> Bruno Lemos -> 98221 <br>
> João Amaral -> 98373 <br>
> João Viegas -> 98372 <br>
> Pedro Rocha -> 98256 <br>

# Explicação da UAP
A UAP guarda os utilizadores e os seus <i>logins</i> nos domínios pretendidos, podendo ter vários utilizadores num só domínio e facilitando a ação do <i>login</i> mas não abdicando da segurança devido ao <i>Enhanced Challenge-Response Authentication Protocol</i>. <br>
Pode apresentar o seu perfil mostrando os seus vários utilizadores para cada domínio. <br>
Tem também a capacidade de adicionar <i>logins</i> num determinado domínio recorrendo ao <i>Add new login</i>.

# Processo de autenticação
Quando na <i>home page</i> da <i>Web App</i> selecionamos o <i>login via UAP</i> somos redirecionados para a UAP abrindo comunicação pelos <i>sockets</i> e ficando à espera do processo <i>E-CHAP</i>. <br>
Do lado da UAP o utilizador é convidado a fazer login e a escolher qual das contas quer utilizar para iniciar sessão no determinado <i>DNS</i>. <br>
Depois de escolhida a conta, é iniciado o processo de autenticação com comunicação por <i>sockets</i>; inicialmente o cliente indica ao servidor qual é o utilizador que está a tentar autenticar-se.
Numa fase seguinte, o servidor verifica a existência desse utilizador na base de dados e após essa verificação envia à UAP um <i>challenge</i> e o <i>salt</i> da <i>password</i>. Do lado da UAP este tem que aplicar o <i>salt</i> à sua <i>password</i> local, produzir o <i>challenge</i> e uma <i>hash</i> de todos estes dados.
O servidor calcula também a <i>hash</i> do <i>challenge</i> com a <i>password</i> da sua base de dados. <br>
É então feita uma comparação bit a bit, sendo enviados 100 bits pela parte da UAP nunca sendo interrompido indepentemente do sucesso da autenticação, que se divide em dois pontos: existência (ou não) de um utilizador e o <i>challenge</i> estar (ou não) correto.
Os 100 bits, anteriormente referidos, foram uma escolha nossa considerando tempo de execução e segurança contra ataques de força bruta.
No fim do processo de autenticação caso haja sucesso, o cliente é redirecionado para a <i>Web App</i> já com a sessão inciada. Caso contrário, é redirecionado para a página de adicionar um novo <i>login</i> válido.
