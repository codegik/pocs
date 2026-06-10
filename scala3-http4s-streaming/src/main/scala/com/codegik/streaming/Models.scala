package com.codegik.streaming

import io.circe.Encoder
import io.circe.Decoder
import io.circe.syntax.*
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import org.http4s.ServerSentEvent

enum JobEvent:
  case Queued(jobId: Long)
  case Started(jobId: Long)
  case Progress(jobId: Long, percent: Int)
  case Completed(jobId: Long, durationMs: Long)
  case Failed(jobId: Long, reason: String)

  def asServerSentEvent: ServerSentEvent =
    ServerSentEvent(data = Some(this.asJson.noSpaces), eventType = Some(productPrefix))

  def isTerminal: Boolean = this match
    case _: Completed | _: Failed => true
    case _                        => false

object JobEvent:
  given Encoder[JobEvent] = deriveEncoder
  given Decoder[JobEvent] = deriveDecoder
