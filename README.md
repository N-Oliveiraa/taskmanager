# TaskManager

Sistema de gerenciamento de tarefas desenvolvido com JavaFX, FXML, CSS, JDBC, MySQL, MVC e testes automatizados com JUnit 5.

---

# Tecnologias Utilizadas

* Java 21
* JavaFX 21
* FXML
* CSS3
* MySQL
* JDBC
* Maven
* JUnit 5
* Dotenv (.env)

---

# Funcionalidades

* Criar atividades
* Listar atividades
* Atualizar atividades
* Excluir atividades
* Marcar atividades como concluídas
* Filtro de atividades
* Contadores:

  * Total
  * Pendentes
  * Concluídas
* Persistência no banco de dados MySQL
* Testes automatizados com JUnit 5

---

# Estrutura do Projeto

```text
TaskManager
│
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   │
│   └── test
│       └── java
│
├── pom.xml
├── .env
├── .env.example
└── README.md
```

---

# Configuração do Banco de Dados

## Banco Principal

Execute o script abaixo no MySQL Workbench:

```sql
CREATE DATABASE taskmanager_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE taskmanager_db;

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    isChecked BOOLEAN DEFAULT FALSE
);
```

---

## Banco de Testes

Execute também o banco de testes para o JUnit:

```sql
CREATE DATABASE taskmanager_test_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE taskmanager_test_db;

CREATE TABLE tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    isChecked BOOLEAN DEFAULT FALSE
);
```

---

# Configuração do .env

Crie um arquivo chamado:

```text
.env
```

na raiz do projeto.

# Arquivo .env.example

```env
DB_URL=jdbc:mysql://localhost:3306/taskmanager_db
DB_USER=root
DB_PASSWORD=123456


TEST_DB_URL=jdbc:mysql://localhost:3306/taskmanager_test_db
TEST_DB_USER=root
TEST_DB_PASSWORD=123456
```

---

# Como Executar o Projeto

## 1. Clonar o repositório

```bash
git clone URL_DO_REPOSITORIO
```

---

## 2. Entrar no projeto

```bash
cd TaskManager
```

---

## 3. Configurar o arquivo .env

Adicionar usuário e senha do MySQL.

---

## 4. Executar o projeto

```bash
mvn clean javafx:run
```

---

# Executar Testes

```bash
mvn test
```

---

# Interface do Sistema

O sistema possui:

* Tela de cadastro
* Tela de listagem
* Cards de atividades
* Contadores de status
* Filtro por atividades

---

# Testes Implementados

## TaskServiceTest

* Validação de título
* Validação de descrição
* Tratamento de campos nulos
* Tratamento de campos vazios

## TaskDAOTest

* Criar atividade
* Listar atividades
* Atualizar atividade
* Atualizar status
* Excluir atividade

## TaskTest


* Criar atividade
* Marcar como concluida


---

# Autor

Nivaldo Oliveira





