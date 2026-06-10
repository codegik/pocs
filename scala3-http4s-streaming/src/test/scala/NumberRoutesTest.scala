package com.codegik.streaming

import cats.effect.IO
import munit.CatsEffectSuite
import org.http4s.*
import org.http4s.implicits.*

class NumberRoutesTest extends CatsEffectSuite:

  private val routes = NumberRoutes[IO].orNotFound

  private def lines(uri: Uri): IO[List[String]] =
    routes.run(Request[IO](Method.GET, uri)).flatMap(_.as[String]).map(_.linesIterator.toList)

  test("streams the requested number of NDJSON lines") {
    lines(uri"/stream/numbers?count=5").map { ls =>
      assertEquals(ls.size, 5)
      assertEquals(ls.head, """{"n":1}""")
      assertEquals(ls.last, """{"n":5}""")
    }
  }

  test("count<=0 yields an empty body") {
    lines(uri"/stream/numbers?count=0").map(ls => assertEquals(ls, Nil))
  }

  test("count is clamped to MaxCount") {
    lines(uri"/stream/numbers?count=999999").map(ls => assertEquals(ls.size, NumberRoutes.MaxCount))
  }

  test("a missing count param does not match the route (404)") {
    routes.run(Request[IO](Method.GET, uri"/stream/numbers")).map(r => assertEquals(r.status, Status.NotFound))
  }
