# 📚 ForHub

Aplicação Java Spring Boot usando apenas back-end, com autenticação JWT, para gerenciamento de perfis, usuários, cursos, tópicos e respostas.  
O sistema implementa controle de acesso baseado em perfis (ex.: **admin**, **user**) e segue arquitetura em camadas, garantindo segurança e organização no código.

**O intuito do projeto é colocar em prática tudo que foi ensinado até o momento do curso, aplicando:**
- Spring Boot
- Arquitetura em camadas
- Uso de DTOs e records
- Anotações Spring
- Spring Security + JWT
- Jpa Repository
- Flyway Migration
- Lombok para redução de código
- Boas práticas de API REST

## ✨ Funcionalidades

-**Observações**
-Após cadastrar perfil com permissões definidas
- Cadastrar usuário vinculado a um perfil
- Todas as demais funcionalidades da aplicação só funcionara se você for na autenticação inserir email e senha corretos do cadastro do usuario existente no banco e será retornado um token para ser inserido nas demais funcionalidades para ter acesso as informações.

- **Perfis**
  - Cadastrar perfil com permissões definidas

- **Usuários**
  - Cadastrar usuário vinculado a um perfil
  - Listar usuários
  - Ativar/Desativar usuário

- **Autenticação**
  - Efetuar login e gerar token JWT

- **Cursos**
  - Cadastrar curso
  - Listar cursos

- **Tópicos**
  - Cadastrar tópico
  - Listar tópicos
  - Detalhar tópico
  - Atualizar tópico
  - Ativar/Desativar tópico

- **Respostas**
  - Cadastrar resposta
  - Listar respostas

## ⚙️ Tecnologias

- **Java 17**
- **Spring Boot**
- **Spring Security (JWT)**
- **Spring Data JPA**
- **PostgreSQL**
- **Flyway Migration**
- **Lombok**
- **GitHub**
- **IntelliJ IDEA**
- **Postman** para testes

## 🖥️ Exemplo de Execução

**Cadastro de Perfil:**
![](imagens/cadastro-usuario.png)



**Cadastro de Usuário:**
![](imagens/cadastro-usuario.png)

---

**Listagem de Usuários (com token JWT):**
![](imagens/lista-usuarios.png)

---

**Cadastro de Curso:**
![](imagens/cadastro-curso.png)

---

**Cadastro de Tópico:**
![](imagens/cadastro-topico.png)

---

**Cadastro de Resposta:**
![](imagens/cadastro-resposta.png)

## 👨🏻‍💻 Autor

- Bernardo Botelho

---

📅 Agosto de 2025
