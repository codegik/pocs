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

## Integration Tests

The project includes comprehensive integration tests for the gRPC API that validate all CRUD operations using Spring Boot's test context with an in-process gRPC server.

### Running Tests

Run all tests:
```bash
mvn test
```

Run only integration tests:
```bash
mvn test -Dtest=UserGrpcServiceIntegrationTest
```

Run a specific test:
```bash
mvn test -Dtest=UserGrpcServiceIntegrationTest#testCreateUser
```

### Test Coverage

The integration test suite includes 11 test cases covering:

- ✅ Create user operations
- ✅ Read/Get user operations (including non-existent users)
- ✅ Update user operations (including non-existent users)
- ✅ Delete user operations (including non-existent users)
- ✅ List all users
- ✅ Create multiple users and list them
- ✅ Edge cases (empty email, full CRUD lifecycle)

### Test Implementation

The tests use:
- **In-Process gRPC Server** - Fast, isolated testing without network overhead
- **Spring Boot Test Context** - Full application context for realistic integration testing
- **Ordered Execution** - Tests run in a specific order to validate user workflow
- **Proper Cleanup** - Each test properly cleans up resources

Example test output:
```
[INFO] Tests run: 11, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
```

For more details, see [INTEGRATION_TESTS.md](INTEGRATION_TESTS.md)

## Technologies Used

- Spring Boot 4.0.1
- JDK 25
- gRPC 1.70.0
- Protocol Buffers 4.29.3
- grpc-spring-boot-starter 3.1.0
