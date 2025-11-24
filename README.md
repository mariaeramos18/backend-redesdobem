# Escola Backend - API Java

Projeto Java para gerenciamento de alunos, turmas e usuários, com autenticação JWT.  

Tecnologias: Java 17+, Jakarta EE (JPA, REST), Hibernate, MySQL, Jersey, Jetty.

---

## Configuração do Banco

1. Crie o banco no MySQL:

\`\`\`sql
CREATE DATABASE escola;
\`\`\`

2. Ajuste \`persistence.xml\` com usuário e senha.

3. Tabelas serão criadas automaticamente (\`hibernate.hbm2ddl.auto=update\`).

---

## Estrutura do Projeto

\`\`\`
src/main/java
├─ entity   	-> Entidades JPA (Aluno, Turma, Usuario)
├─ dao      	-> Persistência (AlunoDao, TurmaDao, UsuarioDao)
├─ service  	-> Regras de negócio
├─ config   	-> Configuração JAX-RS (JaxRsApplication)
└─ controller  -> Endpoints

\`\`\`

---

## Execução

\`\`\`bash
mvn clean install
java -jar target/backend.jar
\`\`\`

API disponível em: \`http://localhost:8080/api/`

---

## Endpoints CRUD

### Usuario

**Exemplos via curl:**

**Incluir/Atualizar**

curl -X POST http://localhost:8080/api/usuario/salvar \\  
     -H "Content-Type: application/json" \\  
     -d '{"email": "teste@teste.com", "nome":"xxx", "senha":"12345"}'

**login**

curl -X POST http://localhost:8080/api/usuario/login \\  
     -H "Content-Type: application/json" \\  
     -d '{"email": "teste@teste.com", "senha":"12345"}'

### Turma

**Exemplos via curl:**

**Incluir**

curl -X POST http://localhost:8080/api/turma/salvar \\  
     -H "Authorization: Bearer \<token-aqui\>" \\  
     -H "Content-Type: application/json" \\  
     -d '{"descricao": "2025.1N"}'

**Atualizar**

curl -X POST http://localhost:8080/api/turma/salvar \\  
     -H "Authorization: Bearer \<token-aqui\>" \\  
     -H "Content-Type: application/json" \\  
     -d '{"id": 1, "descricao": "2025.2N"}'

**Consultar**

curl -X GET http://localhost:8080/api/turma/1 \\  
     -H "Authorization: Bearer \<token-aqui\>"

---

### Aluno

> Senhas são armazenadas como hash SHA-256.

**Incluir**

curl -X POST http://localhost:8080/api/aluno/salvar \
     -H "Authorization: Bearer \<token-aqui\>" \
     -H "Content-Type: application/json" \
     -d '{"nome": "Zezinho", "turma" : {"id":1}}'

**Atualizar**

curl -X POST http://localhost:8080/api/aluno/salvar \
     -H "Authorization: Bearer \<token-aqui\>" \
     -H "Content-Type: application/json" \
     -d '{"id": 1, "nome": "Maria", "turma" : {"id":1}}'

**Consultar**

curl -X GET http://localhost:8080/api/aluno/1 \
     -H "Authorization: Bearer \<token-aqui\>"

---

## Exemplos de JSON de Entidades

**Aluno:**

\`\`\`json
{
  "id": 1,
  "nome": "Maria",
  "turma": {
    "id": 1,
    "descricao": "Turma de Java"
  }
}
\`\`\`

**Turma:**

\`\`\`json
{
  "id": 1,
  "descricao": "Turma de Java"
}
\`\`\`

**Usuário:**

\`\`\`json
{
  "email": "user@ex.com",
  "nome": "João",
  "senha": "hashSHA256aqui"
}
\`\`\`

---

## Testando a API

- Use \`curl\`, Postman ou Insomnia.
- Inclua \`Authorization: Bearer <TOKEN>\` para endpoints protegidos.
- Respostas em JSON.

---

## Autor

Reinaldo José de Freitas 
reinaldo.freitas@rj.senac.br

---

## Licença

MIT License
EOL
---
COMO UTILIZAR A API DO REDES DO BEM?

Para começar utilizar o programa, devemos fazer:

Botão direito no projeto -> Team -> Pull
para atualizar os arquivos na sua máquina que foram alterados no github

Botão direito no projeto -> Run as -> Maven Build…
Em goals, escreva:
-U clean install	-> Run
obs: toda vez que faço uma alteração no projeto, as vezes o erro que dá quando executamos o programa, é por isso.

Dar start no Xampp 
(Apache e MySQL)

Na página inicial, do phpmyadmin, aperte em SQL e escreva:
create database redesdobem

Ir na classe Main e apertar com botão direito
Run as -> Java Application

Abrir o Git bash



---
**Começando por Usuario**

Inserir / Atualizar
curl -X POST http://localhost:8080/api/usuario/salvar \
-H "Content-Type: application/json" \
-d '{"email": "teste@teste.com", "nome":"xxx", "senha":"12345"}'



Login
curl -X POST http://localhost:8080/api/usuario/login \
-H "Content-Type: application/json" \
-d '{"email": "teste@teste.com", "senha":"12345"}'

Vai retornar um hash, é necessário salvar para colocar em outros comandos:
OBS: toda vez que você for fazer esse passo a passo, será criado um token desse novo, então não adianta você copiar direto daqui. PRECISAR TROCAR O TOKEN.
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJpYXQiOjE3NjM1OTI0MzUsImV4cCI6MTc2MzU5NjAzNX0.8ZOunrWg1LKex0wtSAYiWEM1MOdUwXc7fmuVwVRwTO4



---
**Agora com a tabela Organizacao**

Incluir
curl -X POST http://localhost:8080/api/organizacao/salvar \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJpYXQiOjE3NjM2NzIxMTgsImV4cCI6MTc2MzY3NTcxOH0.Ps5NHAWtLikjgqluqKx3aMg0JIPcfDo-_qlukpz8w1I" \
  -H "Content-Type: application/json" \
  -d '{"organizacao_id": 1, "nome": "AmigosDoBem", "cnpj": "123456789", "usuario_id": "teste@teste.com"}'


Atualizar
curl -X POST http://localhost:8080/api/organizacao/salvar \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJpYXQiOjE3NjM2NzIxMTgsImV4cCI6MTc2MzY3NTcxOH0.Ps5NHAWtLikjgqluqKx3aMg0JIPcfDo-_qlukpz8w1I" \
  -H "Content-Type: application/json" \
  -d '{"organizacao_id": 1, "nome": "Maria", "cnpj": "44444444444", "usuario_id": "teste@teste.com"}'


Consultar
curl -X GET http://localhost:8080/api/organizacao/1 \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJpYXQiOjE3NjM2NzIxMTgsImV4cCI6MTc2MzY3NTcxOH0.Ps5NHAWtLikjgqluqKx3aMg0JIPcfDo-_qlukpz8w1I"

---
**Agora a tabela Doacao**


Incluir
curl -X POST http://localhost:8080/api/doacao/salvar \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJpYXQiOjE3NjM2NzQxNjUsImV4cCI6MTc2MzY3Nzc2NX0.TBns1Lkm-SiXAsdqLQC3czZDW2JPtMUmfZa-_oOontM" \
  -H "Content-Type: application/json" \
  -d '{"doacao_id": 1, "tipo_alimento": "Arroz integral", "quantidade": 2, "unidade": "Kg"}'




Atualizar
curl -X POST http://localhost:8080/api/doacao/salvar \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJpYXQiOjE3NjM2NzYzMzcsImV4cCI6MTc2MzY3OTkzN30.-vPjbljPoSZ3O7M5jVTPdiAdjrapsm14Hrr9qoDnFkk" \
  -H "Content-Type: application/json" \
  -d '{"doacao_id": 2, "tipo_alimento": "Feijao", "quantidade": 10, "unidade": "Kg"}'

Consultar

curl -X GET http://localhost:8080/api/doacao/1 \
-H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZUB0ZXN0ZS5jb20iLCJpYXQiOjE3NjM1OTI0MzUsImV4cCI6MTc2MzU5NjAzNX0.8ZOunrWg1LKex0wtSAYiWEM1MOdUwXc7fmuVwVRwTO4"


