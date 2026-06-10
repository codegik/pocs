package com.codegik.streaming

import cats.effect.{IO, Resource}
import com.comcast.ip4s.{host, port}
import munit.CatsEffectSuite
import org.http4s.*
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder

class ServerIntegrationTest extends CatsEffectSuite:

  private val resource: Resource[IO, (Client[IO], Uri)] =
    for
      srv <- EmberServerBuilder
        .default[IO]
        .withHost(host"127.0.0.1")
        .withPort(port"0")
        .withHttpApp(Api.routes[IO])
        .build
      client <- EmberClientBuilder.default[IO].build
    yield
      val base = Uri.unsafeFromString(
        s"http://${srv.address.getHostString}:${srv.address.getPort}"
      )
      (client, base)

  private val fixture = ResourceSuiteLocalFixture("http-server", resource)

  override def munitFixtures = List(fixture)

  private def client: Client[IO] = fixture()._1
  private def base: Uri          = fixture()._2

  test("jobs SSE streams over the wire and terminates on Completed") {
    val req = Request[IO](Method.GET, base / "events" / "jobs" / "2")
    client
      .stream(req)
      .flatMap(_.body.through(ServerSentEvent.decoder[IO]))
      .compile
      .toList
      .map(_.filter(_.eventType.isDefined))
      .map { events =>
        assertEquals(events.size, 6)
        assertEquals(events.last.eventType, Some("Completed"))
      }
  }

  test("numbers stream over the wire") {
    client
      .expect[String]((base / "stream" / "numbers").withQueryParam("count", 4))
      .map(body => assertEquals(body.linesIterator.size, 4))
  }
