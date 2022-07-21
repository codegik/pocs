package com.codegik.poc.task

import com.codegik.poc.task.pool.TaskPool
import org.junit.jupiter.api.Test

class TaskPoolTest {

	@Test
	fun add3Tasks() {
		val taskPool = TaskPool()

		taskPool.add(DelayTask("1", 10000))
		taskPool.add(DelayTask("2", 4000))
		taskPool.add(DelayTask("3", 1000))

		taskPool.waitToFinish()
	}


	@Test
	fun add10Tasks() {
		val taskPool = TaskPool()

		taskPool.add(DelayTask("1", 10000))
		taskPool.add(DelayTask("2", 4000))
		taskPool.add(DelayTask("3", 1000))
		taskPool.add(DelayTask("4", 1000))
		taskPool.add(DelayTask("5", 20000))
		taskPool.add(DelayTask("6", 1000))
		taskPool.add(DelayTask("7", 1000))
		taskPool.add(DelayTask("8", 1000))
		taskPool.add(DelayTask("9", 1000))
		taskPool.add(DelayTask("10", 500))

		taskPool.waitToFinish()
	}


	@Test
	fun add50Tasks() {
		val taskPool = TaskPool()

		for (i in 0..50) {
			taskPool.add(DelayTask("$i", 500))
		}

		taskPool.waitToFinish()
	}

}
