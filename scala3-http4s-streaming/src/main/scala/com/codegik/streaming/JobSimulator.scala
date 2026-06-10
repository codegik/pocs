package com.codegik.streaming

import cats.effect.Temporal
import fs2.Stream

import scala.concurrent.duration.*

object JobSimulator:

  def apply[F[_]: Temporal](jobId: Long, tick: FiniteDuration = 500.millis): Stream[F, JobEvent] =
    val terminal =
      if jobId % 2 == 0 then JobEvent.Completed(jobId, tick.toMillis * 5)
      else JobEvent.Failed(jobId, "simulated failure")

    val events = List(
      JobEvent.Queued(jobId),
      JobEvent.Started(jobId),
      JobEvent.Progress(jobId, 25),
      JobEvent.Progress(jobId, 50),
      JobEvent.Progress(jobId, 75),
      terminal,
    )

    Stream.emits(events).covary[F].metered(tick)
