# scala3-http4s-streaming

http4s + Scala 3 POC, focused on **streaming** rather than buffered
JSON. It serves a job-lifecycle feed as **Server-Sent Events** and a lazily
produced NDJSON byte stream, all built on `fs2.Stream`. The domain is modeled
with a Scala 3 `enum` ADT. Sibling to `scala3-http4s` (which covers REST CRUD) —
deliberately no mutable store, no CRUD, no buffered bodies.

## Stack

- Scala 3.6.4, SBT 1.10.10
- http4s 0.23.30 (ember-server, ember-client, dsl, circe)
- fs2 3.11.0 (`Stream`, `awakeEvery`, `metered`, `ServerSentEvent`)
- circe 0.14.10 for JSON codecs
- cats-effect 3 (`IO`, `Temporal`, `Resource`)
- munit + munit-cats-effect + cats-effect-testkit (`TestControl`) for testing

## Scala 3 / http4s concepts explored

- **`enum` ADT** (`JobEvent`) with per-case fields, `productPrefix` as the SSE
  event type, and a `match` over union-typed cases for `isTerminal`.
- **Server-Sent Events** via http4s's built-in `EntityEncoder` for
  `Stream[F, ServerSentEvent]` (auto `Content-Type: text/event-stream`).
- **fs2 time-based streams** (`awakeEvery`, `metered`) — backpressured and lazy.
- **Raw chunked streaming** of a `Stream[F, Byte]` body (NDJSON), produced lazily.
- **Deterministic testing of timed streams** with cats-effect `TestControl`
  (virtual time, no real sleeps).

## Layout

```
src/main/scala/com/codegik/streaming/
  Models.scala         enum JobEvent + circe codecs + asServerSentEvent
  JobSimulator.scala   builds a finite fs2.Stream[F, JobEvent] for one job
  EventRoutes.scala    SSE routes: /events/clock, /events/jobs/:id
  NumberRoutes.scala   lazy NDJSON byte stream: /stream/numbers
  Api.scala            combines routes (<+>) + Logger middleware -> HttpApp
  Main.scala           boots EmberServer on :8080
```

## Endpoints

| Method | Path                      | Description                                         |
| ------ | ------------------------- | --------------------------------------------------- |
| GET    | `/events/clock`           | Infinite SSE heartbeat (1/sec); `?limit=N` to bound |
| GET    | `/events/jobs/:id`        | Finite SSE job lifecycle; ends on terminal event    |
| GET    | `/stream/numbers?count=N` | Lazy NDJSON stream; `?delayMs=` to space chunks     |

The job lifecycle is `Queued -> Started -> Progress(25/50/75) -> Completed`
(even ids) or `... -> Failed` (odd ids). The SSE `event:` field is the enum case
name; the `data:` field is the event JSON.

## Run

```bash
sbt run
sbt test
```

Serves <http://localhost:8080>

```bash
curl -N localhost:8080/events/jobs/2          # watch the SSE frames stream in, then close
curl -N "localhost:8080/events/clock?limit=5"
curl "localhost:8080/stream/numbers?count=10"
```

`-N` disables curl's buffering so SSE/streamed frames appear as they arrive.
