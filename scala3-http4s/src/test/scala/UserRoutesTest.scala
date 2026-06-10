package com.codegik.http4s

import cats.effect.IO
import io.circe.syntax.*
import munit.CatsEffectSuite
import org.http4s.*
import org.http4s.circe.*
import org.http4s.implicits.*

class UserRoutesTest extends CatsEffectSuite:

  private val alice = UserInput("Alice", "alice@example.com", 30)
  private val bob   = UserInput("Bob", "bob@example.com", 25)

  /** Builds a fresh app over a repo seeded with the given inputs. */
  private def app(seed: List[UserInput] = Nil): IO[HttpApp[IO]] =
    UserRepository.seeded[IO](seed).map(repo => UserRoutes[IO](repo).orNotFound)

  private def post(input: UserInput): Request[IO] =
    Request[IO](Method.POST, uri"/users").withEntity(input.asJson)

  // ---- GET /users -------------------------------------------------------

  test("GET /users returns an empty list initially") {
    for
      routes <- app()
      res    <- routes.run(Request[IO](Method.GET, uri"/users"))
      body   <- res.as[List[User]]
    yield
      assertEquals(res.status, Status.Ok)
      assertEquals(body, Nil)
  }

  test("GET /users lists seeded users") {
    for
      routes <- app(List(alice, bob))
      res    <- routes.run(Request[IO](Method.GET, uri"/users"))
      body   <- res.as[List[User]]
    yield
      assertEquals(res.status, Status.Ok)
      assertEquals(body.map(_.name), List("Alice", "Bob"))
  }

  // ---- GET /users/:id ---------------------------------------------------

  test("GET /users/:id returns the user when present") {
    for
      routes <- app(List(alice))
      res    <- routes.run(Request[IO](Method.GET, uri"/users/1"))
      body   <- res.as[User]
    yield
      assertEquals(res.status, Status.Ok)
      assertEquals(body, User(1L, "Alice", "alice@example.com", 30))
  }

  test("GET /users/:id returns 404 when absent") {
    for
      routes <- app()
      res    <- routes.run(Request[IO](Method.GET, uri"/users/99"))
      err    <- res.as[ApiError]
    yield
      assertEquals(res.status, Status.NotFound)
      assertEquals(err.errors, List("user 99 not found"))
  }

  test("GET /users/:id with non-numeric id falls through to 404") {
    for
      routes <- app()
      res    <- routes.run(Request[IO](Method.GET, uri"/users/abc"))
    yield assertEquals(res.status, Status.NotFound)
  }

  // ---- POST /users ------------------------------------------------------

  test("POST /users creates a user and returns 201") {
    for
      routes <- app()
      res    <- routes.run(post(alice))
      body   <- res.as[User]
    yield
      assertEquals(res.status, Status.Created)
      assertEquals(body.id, 1L)
      assertEquals(body.name, "Alice")
  }

  test("POST /users persists so the user is retrievable afterwards") {
    for
      routes <- app()
      _      <- routes.run(post(alice))
      res    <- routes.run(Request[IO](Method.GET, uri"/users/1"))
      body   <- res.as[User]
    yield assertEquals(body.name, "Alice")
  }

  test("POST /users with invalid body returns 400 with errors") {
    for
      routes <- app()
      res    <- routes.run(post(UserInput("", "bad", -1)))
      err    <- res.as[ApiError]
    yield
      assertEquals(res.status, Status.BadRequest)
      assertEquals(err.errors.size, 3)
  }

  test("POST /users with malformed JSON returns 4xx") {
    for
      routes <- app()
      req = Request[IO](Method.POST, uri"/users").withEntity("not json")
      res <- routes.run(req)
    yield assert(res.status.responseClass == Status.ClientError)
  }

  // ---- PUT /users/:id ---------------------------------------------------

  test("PUT /users/:id updates an existing user") {
    val edit = UserInput("Alice C", "ac@example.com", 31)
    for
      routes <- app(List(alice))
      res    <- routes.run(Request[IO](Method.PUT, uri"/users/1").withEntity(edit.asJson))
      body   <- res.as[User]
    yield
      assertEquals(res.status, Status.Ok)
      assertEquals(body, User(1L, "Alice C", "ac@example.com", 31))
  }

  test("PUT /users/:id returns 404 for an unknown id") {
    for
      routes <- app()
      res    <- routes.run(Request[IO](Method.PUT, uri"/users/5").withEntity(alice.asJson))
    yield assertEquals(res.status, Status.NotFound)
  }

  test("PUT /users/:id with invalid body returns 400") {
    for
      routes <- app(List(alice))
      bad = UserInput("", "x", 999)
      res <- routes.run(Request[IO](Method.PUT, uri"/users/1").withEntity(bad.asJson))
    yield assertEquals(res.status, Status.BadRequest)
  }

  // ---- DELETE /users/:id ------------------------------------------------

  test("DELETE /users/:id removes an existing user and returns 204") {
    for
      routes <- app(List(alice))
      res    <- routes.run(Request[IO](Method.DELETE, uri"/users/1"))
      after  <- routes.run(Request[IO](Method.GET, uri"/users/1"))
    yield
      assertEquals(res.status, Status.NoContent)
      assertEquals(after.status, Status.NotFound)
  }

  test("DELETE /users/:id returns 404 for an unknown id") {
    for
      routes <- app()
      res    <- routes.run(Request[IO](Method.DELETE, uri"/users/1"))
    yield assertEquals(res.status, Status.NotFound)
  }

  // ---- full lifecycle ---------------------------------------------------

  test("create -> read -> update -> delete lifecycle") {
    for
      routes  <- app()
      created <- routes.run(post(alice)).flatMap(_.as[User])
      _       <- routes.run(Request[IO](Method.PUT, uri"/users/1")
                   .withEntity(UserInput("Alice2", "a2@example.com", 33).asJson))
      fetched <- routes.run(Request[IO](Method.GET, uri"/users/1")).flatMap(_.as[User])
      del     <- routes.run(Request[IO](Method.DELETE, uri"/users/1"))
      list    <- routes.run(Request[IO](Method.GET, uri"/users")).flatMap(_.as[List[User]])
    yield
      assertEquals(created.id, 1L)
      assertEquals(fetched.name, "Alice2")
      assertEquals(del.status, Status.NoContent)
      assertEquals(list, Nil)
  }
