package com.codegik.streaming

import cats.effect.IO
import cats.effect.testkit.TestControl
import munit.CatsEffectSuite

class JobSimulatorTest extends CatsEffectSuite:

  test("even job ids complete; the sequence starts queued and ends terminal") {
    TestControl.executeEmbed(JobSimulator[IO](2L).compile.toList).map { events =>
      assertEquals(events.size, 6)
      assertEquals(events.head, JobEvent.Queued(2L))
      assertEquals(events.last, JobEvent.Completed(2L, 2500L))
      assert(events.last.isTerminal)
    }
  }

  test("odd job ids fail with a terminal Failed event") {
    TestControl.executeEmbed(JobSimulator[IO](3L).compile.toList).map { events =>
      assertEquals(events.head, JobEvent.Queued(3L))
      assertEquals(events.last, JobEvent.Failed(3L, "simulated failure"))
    }
  }

  test("only the last event is terminal") {
    TestControl.executeEmbed(JobSimulator[IO](4L).compile.toList).map { events =>
      assertEquals(events.count(_.isTerminal), 1)
      assert(events.init.forall(!_.isTerminal))
    }
  }
