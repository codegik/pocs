package com.codegik.streaming

import cats.effect.{IO, IOApp, Resource}
import cats.syntax.apply.*
import com.comcast.ip4s.{host, port}
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.server.Server

object Main extends IOApp.Simple:

  private def server: Resource[IO, Server] =
    EmberServerBuilder
      .default[IO]
      .withHost(host"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(Api.routes[IO])
      .build

  val run: IO[Unit] =
    server.use(_ => IO.println("Streaming server running on http://localhost:8080") *> IO.never)
