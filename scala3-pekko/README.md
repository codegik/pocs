# Scala 3 + Pekko POC

A simple HTTP API using Scala 3 and Apache Pekko with actors.

## Requirements

- JDK 25
- SBT 1.10.7

## Project Structure

```
src/main/scala/
├── Main.scala          - Entry point with HTTP server
├── Routes.scala        - HTTP route definitions
└── UserActor.scala     - Actor for user management

src/test/scala/
└── IntegrationTest.scala - Integration tests
```

## API Endpoints

- `GET /health` - Health check
- `POST /users?name=<name>` - Create a new user
- `GET /users/{id}` - Get user by ID

## Usage

### Run Everything

```bash
./run.sh
```

This script will:
1. Start the application
2. Wait for it to be ready
3. Run integration tests
4. Terminate the application

### Manual Usage

Start the application:
```bash
sbt run
```

Run tests:
```bash
sbt test
```

### Testing the API

```bash
curl http://localhost:8080/health

curl -X POST http://localhost:8080/users?name=Alice

curl http://localhost:8080/users/1
```

## Architecture

The POC demonstrates:
- **Typed Actors**: UserActor manages state with typed messages
- **HTTP Server**: Pekko HTTP for REST API
- **Ask Pattern**: Routes communicate with actors using ask pattern
- **Integration Tests**: Full HTTP server tests using ScalaTest
