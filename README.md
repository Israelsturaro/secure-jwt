# secure-JWT 🔐

O **secure-JWT** é um projeto inovador que demonstra a implementação de autenticação e autorização utilizando JSON Web Tokens (JWT). Com este projeto, você poderá entender como proteger rotas, validar usuários e gerenciar permissões de forma prática e eficiente.

---

## 📚 Sumário

- [Recursos](#-recursos)
- [Funcionalidades](#-funcionalidades)
- [Pré-requisitos](#-pré-requisitos)
- [Execução](#-execução)
    - [Modo de Desenvolvimento](#modo-de-desenvolvimento)
    - [Docker Compose](#docker-compose)

---

## 🚀 Recursos

- **JWT para Autenticação:** Protege rotas e gerencia permissões.
- **Migrations:** Controle de versão do banco de dados com criação automática de uma conta administrativa para testes.
- **Execução Flexível:** Rodar a aplicação em modo de desenvolvimento ou utilizando Docker Compose.
- **Infraestrutura de Segurança:** Gerenciamento de status e permissões de usuários (ex.: conta ADMIN ativa).

---

## 💡 Funcionalidades

- **Autenticação & Autorização:** Implementação baseada em JWT para autenticar usuários.
- **Conta Administrativa Padrão:** Durante as migrations, o sistema cria automaticamente uma conta admin:
    - **Email:** `email@example.com`
    - **Senha:** `suasenha`
    - **Status:** ATIVO
    - **Permissão:** ADMIN
- **Ambientes Flexíveis:** Execute o projeto localmente em modo dev ou através de containers com Docker Compose.

---

## ⚙️ Pré-requisitos

- **Java 11+**
- **Gradle**
- **Docker & Docker Compose** (caso opte pela execução via container)
- **Banco de Dados:** Configure o seu ambiente de banco (por exemplo, PostgreSQL, MySQL, etc.)
- **Docker e Docker-compose instalados**

---

## 🏃 Execução

### Modo de Desenvolvimento

Inicie a aplicação em modo dev (com live coding e hot reload):

```shell
./gradlew quarkusDev
```

### Docker Compose

Inicie a aplicação utilizando o docker

```shell
docker-compose up
```
