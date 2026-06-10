package com.codegik.streaming

import cats.effect.IO
import cats.effect.testkit.TestControl
import munit.CatsEffectSuite
import org.http4s.*
import org.http4s.implicits.*

class EventRoutesTest extends CatsEffectSuite:

  private val routes = EventRoutes[IO].orNotFound

  test("clock SSE serves text/event-stream and honours ?limit") {
    val req = Request[IO](Method.GET, uri"/events/clock?limit=3")
    val program = routes.run(req).flatMap { resp =>
      resp.body
        .through(ServerSentEvent.decoder[IO])
        .compile
        .toList
        .map(events => resp -> events.filter(_.eventType.isDefined))
    }
    TestControl.executeEmbed(program).map { case (resp, events) =>
      assertEquals(resp.contentType.map(_.mediaType), Some(MediaType.`text/event-stream`))
      assertEquals(events.size, 3)
      assert(events.forall(_.eventType.contains("tick")))
    }
  }

  test("jobs SSE streams the full lifecycle and terminates") {
    val req = Request[IO](Method.GET, uri"/events/jobs/2")
    val program = routes
      .run(req)
      .flatMap(_.body.through(ServerSentEvent.decoder[IO]).compile.toList)
      .map(_.filter(_.eventType.isDefined))
    TestControl.executeEmbed(program).map { events =>
      assertEquals(events.size, 6)
      assertEquals(events.head.eventType, Some("Queued"))
      assertEquals(events.last.eventType, Some("Completed"))
    }
  }

  test("unknown path returns 404") {
    routes.run(Request[IO](Method.GET, uri"/events/nope")).map(r => assertEquals(r.status, Status.NotFound))
  }
