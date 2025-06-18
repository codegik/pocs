# Spring Boot Test Project

This POC demonstrates a simple Spring Boot application with REST APIs for managing Users and Addresses.

The idea is to share Spring Boot context between multiple integration test classes to optimize test execution time and resource usage.

## Technologies Used

- Spring Boot 3.5.0
- Spring Data JDBC
- H2 Database
- RestAssured (for API testing)
- JUnit 5

## Architecture

The project follows a clean, layered architecture:

1. **Domain Layer** - Entity objects representing the business model
2. **Repository Layer** - Data access interfaces using Spring Data JDBC
3. **Service Layer** - Business logic and transaction management
4. **API Layer** - REST controllers exposing HTTP endpoints

## Key Features

- Complete CRUD operations for Users and Addresses
- Lightweight data access with Spring Data JDBC (instead of JPA/Hibernate)
- Constructor-based dependency injection (no @Autowired on fields)
- In-memory H2 database for development and testing
- Comprehensive API-level integration tests

## Database Design

The database consists of two tables:
- `users` - Stores user information (id, name, email)
- `addresses` - Stores addresses (id, street, city, state, zip_code, user_id)

The relationship is designed so that one user can have multiple addresses.

## Testing Strategy

The project uses a comprehensive API-level integration testing approach with several optimizations:

### Shared Application Context

To improve test performance, we use a custom meta-annotation `@ApiIntegrationTest` that allows multiple test classes to share a single Spring application context:

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public @interface ApiIntegrationTest {
}
```

This approach provides significant benefits:
- **Faster Test Execution**: The Spring context only needs to be loaded once for all test classes
- **Reduced Memory Usage**: Only one application context is kept in memory
- **Consistency**: All integration tests use the exact same configuration
- **DRY Principle**: Configuration is centralized in one place

### Integration Test Design

The integration tests:
- Use RestAssured for readable, fluent API testing
- Test the full HTTP request/response cycle
- Verify all CRUD operations at the API level
- Use actual repositories to set up test data
- Clean the database before each test to ensure test isolation

## API Endpoints

### Users API

- `GET /api/users` - List all users
- `GET /api/users/{id}` - Get a specific user
- `POST /api/users` - Create a new user
- `PUT /api/users/{id}` - Update an existing user
- `DELETE /api/users/{id}` - Delete a user

### Addresses API

- `GET /api/addresses` - List all addresses
- `GET /api/addresses/{id}` - Get a specific address
- `GET /api/addresses/user/{userId}` - Get all addresses for a specific user
- `POST /api/addresses` - Create a new address
- `PUT /api/addresses/{id}` - Update an existing address
- `DELETE /api/addresses/{id}` - Delete an address

## Running the Application

```bash
./mvnw spring-boot:run
```

The application will start on port 8080 with an in-memory H2 database.

## Running the Tests

```bash
./mvnw test
```


