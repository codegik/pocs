package com.codegik.http4s

import cats.effect.IO
import munit.CatsEffectSuite
import org.http4s.*
import org.http4s.implicits.*

class HelloRoutesTest extends CatsEffectSuite:

  private val routes = HelloRoutes[IO].orNotFound

  private def run(req: Request[IO]): IO[(Status, String)] =
    routes.run(req).flatMap(r => r.as[String].map(r.status -> _))

  test("GET /hello/:name greets the path segment") {
    val req = Request[IO](Method.GET, uri"/hello/Alice")
    run(req).map { case (status, body) =>
      assertEquals(status, Status.Ok)
      assertEquals(body, "Hello, Alice!")
    }
  }

  test("GET /hello/:name?loud=true upper-cases the greeting") {
    val req = Request[IO](Method.GET, uri"/hello/Alice?loud=true")
    run(req).map { case (status, body) =>
      assertEquals(status, Status.Ok)
      assertEquals(body, "HELLO, ALICE!")
    }
  }

  test("GET /hello/:name?loud=false keeps normal case") {
    val req = Request[IO](Method.GET, uri"/hello/Bob?loud=false")
    run(req).map { case (_, body) => assertEquals(body, "Hello, Bob!") }
  }

  test("GET /health returns ok status JSON") {
    val req = Request[IO](Method.GET, uri"/health")
    run(req).map { case (status, body) =>
      assertEquals(status, Status.Ok)
      assertEquals(body, """{"status":"ok"}""")
    }
  }

  test("unknown path returns 404") {
    val req = Request[IO](Method.GET, uri"/nope")
    routes.run(req).map(r => assertEquals(r.status, Status.NotFound))
  }

  // An OptionalQueryParamDecoderMatcher with an unparseable value does not
  // match the route, so http4s falls through to a 404 (use the *Validating*
  // matcher if you want a 400 instead).
  test("unparseable boolean query param falls through to 404") {
    val req = Request[IO](Method.GET, uri"/hello/Alice?loud=maybe")
    routes.run(req).map(r => assertEquals(r.status, Status.NotFound))
  }
