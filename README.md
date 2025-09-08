# 📋 Task Management API

<div align="center">

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen)
![Java](https://img.shields.io/badge/Java-21-orange)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-3.5.5-green)

**Uma API RESTful completa para gerenciamento de tarefas desenvolvida com Spring Boot**

[🚀 Começar](#-como-executar) • [📚 Documentação](#-documentação-da-api) • [🔧 Tecnologias](#-tecnologias-utilizadas)

</div>

---

## 📖 Sobre o Projeto

Esta API foi desenvolvida como parte de um trabalho acadêmico de **Desenvolvimento Web Backend**, implementando uma solução completa para gerenciamento de tarefas. A aplicação permite realizar operações CRUD (Create, Read, Update, Delete) em tarefas, incluindo informações como nome, data de entrega e responsável.

### ✨ Funcionalidades

- ✅ **Criar tarefas** com nome, data de entrega e responsável
- 🔍 **Consultar todas as tarefas** cadastradas
- 🔎 **Buscar tarefa específica** por ID
- ✏️ **Atualizar tarefas** existentes
- 🗑️ **Remover tarefas** do sistema
- 📊 **Validação de dados** com formatação de data
- 🛡️ **Tratamento de erros** HTTP adequado

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| **Java** | 21 | Linguagem de programação |
| **Spring Boot** | 3.5.5 | Framework principal |
| **Spring Data JPA** | 3.5.5 | Persistência de dados (herda do Spring Boot) |
| **MySQL Connector** | - | Driver MySQL (versão gerenciada pelo Spring Boot) |
| **Maven** | - | Gerenciamento de dependências |
| **Jakarta Persistence** | - | API de persistência (herda do Spring Boot) |

---

## 🚀 Como Executar

### Pré-requisitos

- ☕ Java 21 ou superior
- 🗄️ MySQL (qualquer versão compatível)
- 🔧 Maven 3.6 ou superior

### 1. Clone o repositório

```bash
git clone https://github.com/issaahr/task-management-api.git
cd aulap
```

### 2. Configure o banco de dados (OPCIONAL)

O banco de dados será criado automaticamente se não existir, mas você pode criar manualmente:

```sql
CREATE DATABASE bd_mvc;
```
> **Nota:** A configuração `createDatabaseIfNotExist=true` no `application.properties` cria o banco automaticamente.

### 3. Configure as credenciais

Edite o arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bd_mvc?createDatabaseIfNotExist=true
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### 4. Execute a aplicação

```bash
# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

---

## 📚 Documentação da API

### Base URL

```
http://localhost:8080/task
```

### Endpoints Disponíveis

#### 📋 Listar todas as tarefas

```http
GET /task
```

**Resposta:**

```json
[
  {
    "id": 1,
    "name": "Estudar Spring Boot",
    "deadline": "2024-12-31",
    "assignee": "João Silva"
  }
]
```

#### 🔍 Buscar tarefa por ID

```http
GET /task/{id}
```

**Parâmetros:**

- `id` (Long) - ID da tarefa

**Resposta (200):**

```json
{
  "id": 1,
  "name": "Estudar Spring Boot",
  "deadline": "2024-12-31",
  "assignee": "João Silva"
}
```

**Resposta (404):**

```json
Not Found
```

#### ➕ Criar nova tarefa

```http
POST /task
Content-Type: application/json
```

**Corpo da requisição:**

```json
{
  "name": "Implementar API REST",
  "deadline": "2024-12-25",
  "assignee": "Maria Santos"
}
```

**Resposta (200):**

```json
{
  "id": 2,
  "name": "Implementar API REST",
  "deadline": "2024-12-25",
  "assignee": "Maria Santos"
}
```

#### ✏️ Atualizar tarefa

```http
PUT /task/{id}
Content-Type: application/json
```

**Parâmetros:**

- `id` (Long) - ID da tarefa

**Corpo da requisição:**

```json
{
  "name": "Estudar Spring Boot - Atualizado",
  "deadline": "2024-12-30",
  "assignee": "João Silva"
}
```

**Resposta (200):**

```json
{
  "id": 1,
  "name": "Estudar Spring Boot - Atualizado",
  "deadline": "2024-12-30",
  "assignee": "João Silva"
}
```

#### 🗑️ Deletar tarefa

```http
DELETE /task/{id}
```

**Parâmetros:**

- `id` (Long) - ID da tarefa

**Resposta (200):**

```
OK
```

**Resposta (404):**

```
Not Found
```

---

## 🧪 Testando a API

### Usando Postman

1. **Importe a coleção** (se disponível)
2. **Configure a base URL** como `http://localhost:8080`
3. **Execute os requests** na ordem:
   - POST para criar uma tarefa
   - GET para listar todas
   - GET com ID para buscar específica
   - PUT para atualizar
   - DELETE para remover

### Usando cURL

```bash
# Criar tarefa
curl -X POST http://localhost:8080/task \
  -H "Content-Type: application/json" \
  -d '{"name":"Teste API","deadline":"2024-12-31","assignee":"Teste"}'

# Listar todas
curl -X GET http://localhost:8080/task

# Buscar por ID
curl -X GET http://localhost:8080/task/1

# Atualizar
curl -X PUT http://localhost:8080/task/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Tarefa Atualizada","deadline":"2024-12-30","assignee":"Novo Responsável"}'

# Deletar
curl -X DELETE http://localhost:8080/task/1
```

---

## 📁 Estrutura do Projeto

```
aulap/
├── src/
│   ├── main/
│   │   ├── java/com/pratica/aulap/
│   │   │   ├── AulapApplication.java          # Classe principal
│   │   │   ├── controller/
│   │   │   │   └── TaskController.java        # Controller REST
│   │   │   ├── model/
│   │   │   │   └── Task.java                  # Entidade JPA
│   │   │   └── repository/
│   │   │       └── TaskRepository.java        # Interface Repository
│   │   └── resources/
│   │       └── application.properties         # Configurações
│   └── test/
├── pom.xml                                    # Dependências Maven
└── README.md                                  # Este arquivo
```

---

## 🔧 Configurações

### application.properties

```properties
# Aplicação
spring.application.name=demorest

# Banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/bd_mvc?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.open-in-view=true
```

---

## 📊 Códigos de Status HTTP

| Código | Descrição |
|--------|-----------|
| 200 | OK - Operação realizada com sucesso |
| 201 | Created - Recurso criado com sucesso |
| 404 | Not Found - Recurso não encontrado |
| 400 | Bad Request - Dados inválidos |
| 500 | Internal Server Error - Erro interno do servidor |

## 📄 Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para detalhes.

Desenvolvido para fins acadêmicos como parte de um trabalho de **Desenvolvimento Web Backend**.

---

<div align="center">

**⭐ Se este projeto foi útil, deixe uma estrela! ⭐**

Desenvolvido com ❤️ usando Spring Boot

</div>
