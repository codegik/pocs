# Vert.x User CRUD System - JDK 25

A simple in-memory CRUD system for managing users using Vert.x framework and JDK 25.

## Prerequisites

- JDK 25
- Maven 3.6+


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

The server will start on port 8080.

```bash
mvn exec:java
```

## Running Tests

Run the integration tests:

```bash
mvn test
```

## Running API Tests

This will start the application, run API tests against it, and then stop the application.

```bash
./test-api.sh
```

## Features

- ✅ Simple and clean architecture
- ✅ In-memory storage using ConcurrentHashMap
- ✅ RESTful API design
- ✅ Integration tests
- ✅ No mocks in tests
- ✅ Latest versions of libraries
- ✅ JDK 25 compatible
