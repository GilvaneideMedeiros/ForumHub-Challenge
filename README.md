# ForumHub API

![Java](https://img.shields.io/badge/Java-17%2B-blue?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=spring&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-4.0-red?style=for-the-badge&logo=apache-maven&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON-Web-Tokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Lombok](https://img.shields.io/badge/Lombok-E0234E?style=for-the-badge&logo=Lombok&logoColor=white)

---

## 📖 Sobre o Projeto

O **ForumHub é uma API RESTful, um challenge proposto pela Formação Java e Spring Framework G8 - ONE, parte da especialização back-end do Programa ONE, uma iniciativa da Oracle Next Education em parceria com a Alura**. A aplicação simula um fórum de discussão, permitindo que usuários autenticados criem, leiam, atualizem e excluam tópicos.

O projeto foi construído com foco em boas práticas de desenvolvimento, como arquitetura REST, segurança baseada em tokens JWT, versionamento de banco de dados com Flyway e documentação de API com SpringDoc/Swagger.

---

## ✨ Funcionalidades

* **CRUD de Tópicos**: Operações completas de Criação, Leitura, Atualização e Deleção de tópicos.
* **Autenticação via Token JWT**: Sistema de login que gera um token JWT para autenticação _stateless_ nas requisições subsequentes.
* **Autorização por Perfil (Role)**: Endpoints protegidos com base em perfis de usuário (`ROLE_USER`, `ROLE_ADMIN`).
* **CRUD de Perfis**: Gerenciamento de perfis de usuário, acessível apenas para administradores.
* **Validações**: Validações de dados de entrada utilizando o Bean Validation.
* **Paginação e Ordenação**: As listagens de recursos são paginadas e ordenadas para melhor performance.
* **Tratamento de Erros**: Respostas de erro padronizadas e informativas para diferentes cenários (ex: `404 Not Found`, `400 Bad Request`, `403 Forbidden`).
* **Documentação com Swagger**: Geração automática de uma documentação de API interativa.

---

## 🎥 Demonstração em Vídeo

Assista a um vídeo demonstrando as principais funcionalidades da API em ação.

*([Link para o vídeo aqui](https://youtu.be/zwnMJMkooNs?si=zWW-U4N0n24qPbT1))*

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**: Linguagem de programação principal.
* **Spring Boot 3**: Framework para criação de aplicações web robustas.
* **Spring Security**: Para controle de autenticação e autorização.
* **Spring Data JPA**: Para persistência de dados.
* **Maven**: Gerenciador de dependências e _build_ do projeto.
* **MySQL**: Banco de dados relacional.
* **Flyway**: Ferramenta para versionamento e migração de _schema_ do banco de dados.
* **Lombok**: Para reduzir código _boilerplate_ (getters, setters, construtores).
* **JWT (Java Web Token)**: Para geração e validação de tokens de autenticação.
* **SpringDoc (Swagger/OpenAPI)**: Para documentação automática da API.

---

## 🌳 Estrutura do Projeto

A estrutura de pacotes foi organizada por funcionalidade, separando as responsabilidades de cada componente da aplicação.
```
.
└── src
    └── main
        ├── java
        │   └── com
        │       └── gilvaneide
        │           └── forumhub
        │               ├── ForumHubApplication.java
        │               ├── infra
        │               │   ├── exception
        │               │   │   ├── InvalidTokenException.java
        │               │   │   └── TratadorDeErros.java
        │               │   ├── security
        │               │   │   ├── SecurityConfigurations.java
        │               │   │   ├── SecurityFilter.java
        │               │   │   └── TokenService.java
        │               │   └── springdoc
        │               │       └── SpringDocConfigurations.java
        │               ├── perfil
        │               │   ├── controller
        │               │   │   └── PerfilController.java
        │               │   ├── dto
        │               │   │   ├── DadosCadastroPerfil.java
        │               │   │   └── DadosListagemPerfil.java
        │               │   ├── entity
        │               │   │   └── Perfil.java
        │               │   └── repository
        │               │       └── PerfilRepository.java
        │               ├── topico
        │               │   └── ... (controller, dto, entity, repository)
        │               └── usuario
        │                   ├── dto
        │                   │   └── DadosAutenticacao.java
        │                   ├── entity
        │                   │   └── Usuario.java
        │                   └── repository
        │                       └── UsuarioRepository.java
        └── resources
            ├── db
            │   └── migration
            │       └── V1__create-initial-tables-and-data.sql
            └── application.properties

```
---

## 🚀 Como Executar o Projeto

### Pré-requisitos
* Java JDK 17 ou superior
* Maven 3.8 ou superior
* MySQL Server

### Passos

1.  **Clone o repositório:**
    ```shell
    git clone [https://github.com/seu-usuario/forum-hub.git](https://github.com/seu-usuario/forum-hub.git)
    cd forum-hub
    ```

2.  **Configure o Banco de Dados:**
    * Crie um banco de dados no MySQL chamado `forumhub`.
    * Abra o arquivo `src/main/resources/application.properties` e altere as propriedades `spring.datasource.username` e `spring.datasource.password` com suas credenciais do MySQL.

3.  **Execute a Aplicação:**
    * Pela sua IDE, execute a classe `ForumHubApplication.java`.
    * Ou pelo terminal, na raiz do projeto, execute o comando Maven:
    ```shell
    mvn spring-boot:run
    ```

4.  **Acesse a Documentação da API:**
    * Com a aplicação rodando, acesse a seguinte URL no seu navegador para ver a documentação interativa do Swagger:
    `http://localhost:8080/swagger-ui.html`

---

## Endpoints da API

A API possui os seguintes endpoints:

| Método | Endpoint         | Protegido | Perfil Necessário | Descrição                                     |
| :----- | :--------------- | :-------- | :---------------- | :-------------------------------------------- |
| POST   | `/login`         | Não       | -                 | Autentica um usuário e retorna um token JWT.  |
| GET    | `/topicos`       | Sim       | `ROLE_USER`       | Lista todos os tópicos de forma paginada.     |
| POST   | `/topicos`       | Sim       | `ROLE_USER`       | Cadastra um novo tópico.                      |
| GET    | `/topicos/{id}`  | Sim       | `ROLE_USER`       | Exibe os detalhes de um tópico específico.    |
| PUT    | `/topicos/{id}`  | Sim       | `ROLE_USER`       | Atualiza os dados de um tópico.               |
| DELETE | `/topicos/{id}`  | Sim       | `ROLE_USER`       | Exclui um tópico.                             |
| GET    | `/perfis`        | Sim       | `ROLE_ADMIN`      | Lista todos os perfis de usuário.             |
| POST   | `/perfis`        | Sim       | `ROLE_ADMIN`      | Cadastra um novo perfil.                      |
| DELETE | `/perfis/{id}`   | Sim       | `ROLE_ADMIN`      | Exclui um perfil.                             |

---

## 👨‍💻 Autor
Desenvolvido com ❤️ por Gilvaneide Medeiros

## 📞 Contato
Se você tiver alguma pergunta ou sugestão, não hesite em entrar em contato comigo. Vamos conversar!
[![Linkedin](https://img.shields.io/badge/Linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gilvaneide-bertaccini/)

