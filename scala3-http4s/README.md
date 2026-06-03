# scala3-http4s

A small POC demonstrating [http4s](https://http4s.org/) with Scala 3 — a JSON
REST API for a `User` resource, served by Ember and backed by an in-memory,
concurrency-safe repository. The focus is breadth of tests over feature count.

## Stack

- Scala 3.6.4, SBT 1.10.10
- http4s 0.23.30 (ember-server, ember-client, dsl, circe)
- circe 0.14.10 for JSON codecs
- cats-effect 3 (`IO`, `Ref`, `Resource`)
- munit + munit-cats-effect for testing

## Layout

```
src/main/scala/http4s_poc/
  Models.scala          User / UserInput / ApiError + circe & http4s codecs
  UserRepository.scala   Ref-based in-memory store (CRUD, seeding, counting)
  HelloRoutes.scala      path params, optional query params, JSON health probe
  UserRoutes.scala       REST CRUD routes for /users
  Api.scala              combines routes (<+>) + Logger middleware -> HttpApp
  Main.scala             boots EmberServer on :8080 with seeded data
```

## Endpoints

| Method | Path           | Description                          |
|--------|----------------|--------------------------------------|
| GET    | `/health`      | Liveness probe (`{"status":"ok"}`)   |
| GET    | `/hello/:name` | Greeting; `?loud=true` upper-cases   |
| GET    | `/users`       | List all users                       |
| GET    | `/users/:id`   | Fetch one user (404 if absent)       |
| POST   | `/users`       | Create (validates body, 201/400)     |
| PUT    | `/users/:id`   | Replace (404/400)                    |
| DELETE | `/users/:id`   | Delete (204/404)                     |

## Run

```bash
sbt run        # serves http://localhost:8080
sbt test       # 51 tests
```

```bash
curl localhost:8080/users
curl -X POST localhost:8080/users \
  -H 'Content-Type: application/json' \
  -d '{"name":"Carol","email":"carol@example.com","age":40}'
```

## Tests (51 total)

- **ModelsTest** — circe round-trips and `UserInput.validate` rules.
- **UserRepositoryTest** — CRUD, id assignment, seeding, concurrent creates.
- **HelloRoutesTest** — drives `HttpRoutes` in-memory (path/query params, 404s).
- **UserRoutesTest** — full CRUD over the routes, validation and error envelopes.
- **ServerIntegrationTest** — boots a real Ember server on an ephemeral port and
  drives it end-to-end with a real Ember client.
