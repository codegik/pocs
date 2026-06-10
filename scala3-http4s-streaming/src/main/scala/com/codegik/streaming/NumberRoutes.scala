package com.codegik.streaming

import cats.effect.Temporal
import fs2.{Stream, text}
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import org.http4s.dsl.impl.{OptionalQueryParamDecoderMatcher, QueryParamDecoderMatcher}

import scala.concurrent.duration.*

object NumberRoutes:

  val MaxCount = 10000

  object CountParam extends QueryParamDecoderMatcher[Int]("count")
  object DelayParam extends OptionalQueryParamDecoderMatcher[Int]("delayMs")

  def apply[F[_]: Temporal]: HttpRoutes[F] =
    val dsl = Http4sDsl[F]
    import dsl.*

    HttpRoutes.of[F] {
      case GET -> Root / "stream" / "numbers" :? CountParam(count) +& DelayParam(delayMs) =>
        val n     = count.max(0).min(MaxCount)
        val lines = Stream.range(1, n + 1).map(i => s"""{"n":$i}\n""").covary[F]
        val spaced = delayMs.filter(_ > 0).fold(lines)(d => lines.metered(d.millis))
        Ok(spaced.through(text.utf8.encode))
    }
