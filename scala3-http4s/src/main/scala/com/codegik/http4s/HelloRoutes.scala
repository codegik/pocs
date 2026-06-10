package com.codegik.http4s

import cats.effect.Concurrent
import org.http4s.HttpRoutes
import org.http4s.circe.* // EntityEncoder for io.circe.Json
import org.http4s.dsl.Http4sDsl
import org.http4s.dsl.impl.OptionalQueryParamDecoderMatcher

/** Simple routes showing path params, optional query params and JSON output. */
object HelloRoutes:

  // Optional ?loud=true query param, decoded as Boolean.
  object LoudParam extends OptionalQueryParamDecoderMatcher[Boolean]("loud")

  def apply[F[_]: Concurrent]: HttpRoutes[F] =
    val dsl = Http4sDsl[F]
    import dsl.*

    HttpRoutes.of[F] {
      // GET /hello/:name  ->  greets the path segment
      case GET -> Root / "hello" / name :? LoudParam(loud) =>
        val greeting = s"Hello, $name!"
        Ok(if loud.getOrElse(false) then greeting.toUpperCase else greeting)

      // GET /health -> liveness probe as JSON
      case GET -> Root / "health" =>
        Ok(io.circe.Json.obj("status" -> io.circe.Json.fromString("ok")))
    }
