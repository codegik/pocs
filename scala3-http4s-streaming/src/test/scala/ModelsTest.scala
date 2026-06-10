package com.codegik.streaming

import io.circe.parser.decode
import io.circe.syntax.*
import munit.FunSuite

class ModelsTest extends FunSuite:

  test("each JobEvent round-trips through JSON") {
    val events = List(
      JobEvent.Queued(1L),
      JobEvent.Started(1L),
      JobEvent.Progress(1L, 50),
      JobEvent.Completed(1L, 2500L),
      JobEvent.Failed(1L, "boom"),
    )
    events.foreach(e => assertEquals(decode[JobEvent](e.asJson.noSpaces), Right(e)))
  }

  test("asServerSentEvent uses the case name as the event type") {
    assertEquals(JobEvent.Progress(1L, 25).asServerSentEvent.eventType, Some("Progress"))
    assertEquals(JobEvent.Queued(1L).asServerSentEvent.eventType, Some("Queued"))
  }

  test("asServerSentEvent data decodes back to the original event") {
    val event = JobEvent.Completed(3L, 1500L)
    val data  = event.asServerSentEvent.data.getOrElse("")
    assertEquals(decode[JobEvent](data), Right(event))
  }

  test("Completed and Failed are terminal; the rest are not") {
    assert(JobEvent.Completed(1L, 0L).isTerminal)
    assert(JobEvent.Failed(1L, "x").isTerminal)
    assert(!JobEvent.Queued(1L).isTerminal)
    assert(!JobEvent.Started(1L).isTerminal)
    assert(!JobEvent.Progress(1L, 10).isTerminal)
  }
