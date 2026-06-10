package com.codegik.http4s

import cats.effect.{IO, IOApp, Resource}
import cats.syntax.apply.* // *> combinator
import com.comcast.ip4s.{host, port}
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Server

/** Boots an Ember server on http://localhost:8080 with a few seeded users. */
object Main extends IOApp.Simple:

  private val seed = List(
    UserInput("Alice", "alice@example.com", 30),
    UserInput("Bob", "bob@example.com", 25),
  )

  private def server: Resource[IO, Server] =
    for
      repo   <- Resource.eval(UserRepository.seeded[IO](seed))
      server <- EmberServerBuilder
        .default[IO]
        .withHost(host"0.0.0.0")
        .withPort(port"8080")
        .withHttpApp(Api.routes(repo))
        .build
    yield server

  val run: IO[Unit] =
    server.use(_ => IO.println("Server running on http://localhost:8080") *> IO.never)
