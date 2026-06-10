package com.codegik.streaming

import cats.effect.Temporal
import fs2.Stream
import org.http4s.{HttpRoutes, ServerSentEvent}
import org.http4s.dsl.Http4sDsl
import org.http4s.dsl.impl.OptionalQueryParamDecoderMatcher

import scala.concurrent.duration.*

object EventRoutes:

  object LimitParam extends OptionalQueryParamDecoderMatcher[Int]("limit")

  def apply[F[_]: Temporal]: HttpRoutes[F] =
    val dsl = Http4sDsl[F]
    import dsl.*

    HttpRoutes.of[F] {
      case GET -> Root / "events" / "clock" :? LimitParam(limit) =>
        val ticks: Stream[F, ServerSentEvent] =
          Stream.awakeEvery[F](1.second).zipWithIndex.map { case (elapsed, i) =>
            ServerSentEvent(
              data = Some(s"""{"tick":${i + 1},"elapsedMs":${elapsed.toMillis}}"""),
              eventType = Some("tick"),
            )
          }
        val limited = limit.filter(_ > 0).fold(ticks)(n => ticks.take(n.toLong))
        Ok(limited)

      case GET -> Root / "events" / "jobs" / LongVar(id) =>
        Ok(JobSimulator[F](id).map(_.asServerSentEvent))
    }
