# Vert.x User CRUD System - JDK 25

A simple in-memory CRUD system for managing users using Vert.x framework and JDK 25.

## Prerequisites

- JDK 25
- Maven 3.6+

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/codegik/vertx/
│           ├── Main.java                    # Application entry point
│           ├── MainVerticle.java            # Main Vert.x verticle
│           ├── handler/
│           │   └── UserHandler.java         # HTTP request handlers
│           ├── model/
│           │   └── User.java                # User model
│           └── repository/
│               └── UserRepository.java      # In-memory user repository
└── test/
    └── java/
        └── com/codegik/vertx/
            └── UserCrudIntegrationTest.java # Integration tests
```

## Technologies

- **JDK 25**: Latest Java version
- **Vert.x 4.5.11**: Reactive toolkit for the JVM
- **Maven**: Build tool
- **JUnit 5**: Testing framework

## API Endpoints

| Method | Endpoint           | Description          |
|--------|-------------------|----------------------|
| GET    | /health           | Health check         |
| POST   | /api/users        | Create a new user    |
| GET    | /api/users        | Get all users        |
| GET    | /api/users/:id    | Get user by ID       |
| PUT    | /api/users/:id    | Update user by ID    |
| DELETE | /api/users/:id    | Delete user by ID    |

## User Model

```json
{
  "id": "string",
  "name": "string",
  "email": "string"
}
```

## Running the Application

### Build the project

```bash
mvn clean compile
```

### Run the application

```bash
mvn exec:java
```

The server will start on port 8080.

## Running Tests

Run the integration tests:

```bash
mvn test
```

## Example API Usage

### Create a user

```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","email":"john.doe@example.com"}'
```

### Get all users

```bash
curl http://localhost:8080/api/users
```

### Get user by ID

```bash
curl http://localhost:8080/api/users/{id}
```

### Update user

```bash
curl -X PUT http://localhost:8080/api/users/{id} \
  -H "Content-Type: application/json" \
  -d '{"name":"Jane Doe","email":"jane.doe@example.com"}'
```

### Delete user

```bash
curl -X DELETE http://localhost:8080/api/users/{id}
```

## Features

- ✅ Simple and clean architecture
- ✅ In-memory storage using ConcurrentHashMap
- ✅ RESTful API design
- ✅ Comprehensive integration tests
- ✅ No mocks in tests
- ✅ Latest versions of libraries
- ✅ JDK 25 compatible
