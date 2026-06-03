package http4s_poc

import cats.effect.{IO, Resource}
import com.comcast.ip4s.{host, port}
import io.circe.syntax.*
import munit.CatsEffectSuite
import org.http4s.*
import org.http4s.circe.*
import org.http4s.client.Client
import org.http4s.ember.client.EmberClientBuilder
import org.http4s.ember.server.EmberServerBuilder

/** Boots a real Ember server on an ephemeral port and drives it with a real
  * Ember client end-to-end.
  */
class ServerIntegrationTest extends CatsEffectSuite:

  private val resource: Resource[IO, (Client[IO], Uri)] =
    for
      repo <- Resource.eval(UserRepository.empty[IO])
      srv <- EmberServerBuilder
        .default[IO]
        .withHost(host"127.0.0.1")
        .withPort(port"0") // ephemeral
        .withHttpApp(Api.routes(repo))
        .build
      client <- EmberClientBuilder.default[IO].build
    yield
      val base = Uri.unsafeFromString(
        s"http://${srv.address.getHostString}:${srv.address.getPort}"
      )
      (client, base)

  // Shared (client + base uri) fixture for the whole suite.
  private val fixture = ResourceSuiteLocalFixture("http-server", resource)

  override def munitFixtures = List(fixture)

  private def client: Client[IO] = fixture()._1
  private def base: Uri          = fixture()._2

  test("health endpoint responds over the wire") {
    client.expect[String](base / "health").map { body =>
      assertEquals(body, """{"status":"ok"}""")
    }
  }

  test("hello endpoint responds over the wire") {
    client.expect[String](base / "hello" / "World").map { body =>
      assertEquals(body, "Hello, World!")
    }
  }

  test("can create then fetch a user over the wire") {
    val input = UserInput("Dave", "dave@example.com", 28)
    for
      created <- client.expect[User](
        Request[IO](Method.POST, base / "users").withEntity(input.asJson)
      )
      fetched <- client.expect[User](base / "users" / created.id.toString)
    yield
      assertEquals(created.name, "Dave")
      assertEquals(fetched, created)
  }

  test("fetching an unknown user yields a 404 failure") {
    val req = Request[IO](Method.GET, base / "users" / "12345")
    client.status(req).map(s => assertEquals(s, Status.NotFound))
  }
