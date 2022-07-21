package com.codegik.poc.task

import com.codegik.poc.task.pool.TaskPool
import org.junit.jupiter.api.Test

internal class TaskPoolTest {

	@Test
	fun add3Tasks() {
		val taskPool = TaskPool()

		taskPool.add(SimpleTask("1", 10000))
		taskPool.add(SimpleTask("2", 4000))
		taskPool.add(SimpleTask("3", 1000))

		taskPool.waitToFinish()
	}


	@Test
	fun add10Tasks() {
		val taskPool = TaskPool()

		taskPool.add(SimpleTask("1", 10000))
		taskPool.add(SimpleTask("2", 4000))
		taskPool.add(SimpleTask("3", 1000))
		taskPool.add(SimpleTask("4", 1000))
		taskPool.add(SimpleTask("5", 20000))
		taskPool.add(SimpleTask("6", 1000))
		taskPool.add(SimpleTask("7", 1000))
		taskPool.add(SimpleTask("8", 1000))
		taskPool.add(SimpleTask("9", 1000))
		taskPool.add(SimpleTask("10", 500))

		taskPool.waitToFinish()
	}


	@Test
	fun add50Tasks() {
		val taskPool = TaskPool()

		for (i in 0..50) {
			taskPool.add(SimpleTask("$i", 500))
		}

		taskPool.waitToFinish()
	}

}
