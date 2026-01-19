# Spring Boot 4.0.1 + JDK 25 gRPC CRUD POC

A proof of concept demonstrating a basic CRUD API using gRPC with Spring Boot 4.0.1 and JDK 25.

## Prerequisites

- JDK 25 (managed via SDKMAN)
- Maven 3.6+
- SDKMAN installed

## Setup

1. Install and use JDK 25:
```bash
sdk env install
sdk env
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The gRPC server will start on port 9090.

## Project Structure

- `src/main/proto/` - Protocol Buffer definitions
- `src/main/java/com/codegik/grpc/` - Java source code
  - `service/` - gRPC service implementation
  - `model/` - Domain models
  - `repository/` - In-memory data repository

## gRPC API

The service provides the following operations:

- **CreateUser** - Create a new user
- **GetUser** - Get a user by ID
- **UpdateUser** - Update an existing user
- **DeleteUser** - Delete a user by ID
- **ListUsers** - List all users

## Testing with grpcurl

Install grpcurl:
```bash
go install github.com/fullstorydev/grpcurl/cmd/grpcurl@latest
```

### List services:
```bash
grpcurl -plaintext localhost:9090 list
```

### Create a user:
```bash
grpcurl -plaintext -d '{"name": "John Doe", "email": "john@example.com"}' \
  localhost:9090 user.UserService/CreateUser
```

### Get a user:
```bash
grpcurl -plaintext -d '{"id": 1}' \
  localhost:9090 user.UserService/GetUser
```

### Update a user:
```bash
grpcurl -plaintext -d '{"id": 1, "name": "Jane Doe", "email": "jane@example.com"}' \
  localhost:9090 user.UserService/UpdateUser
```

### Delete a user:
```bash
grpcurl -plaintext -d '{"id": 1}' \
  localhost:9090 user.UserService/DeleteUser
```

### List all users:
```bash
grpcurl -plaintext -d '{}' \
  localhost:9090 user.UserService/ListUsers
```

## Technologies Used

- Spring Boot 4.0.1
- JDK 25
- gRPC 1.70.0
- Protocol Buffers 4.29.3
- grpc-spring-boot-starter 3.1.0
