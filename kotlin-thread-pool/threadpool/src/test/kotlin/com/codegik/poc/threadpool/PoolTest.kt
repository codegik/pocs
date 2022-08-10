package com.codegik.poc.threadpool

import com.codegik.poc.threadpool.pool.ThreadPool
import com.codegik.poc.threadpool.task.DelayTask
import org.junit.jupiter.api.Test

class PoolTest {

	private val repeatTaskCreation = 3000
	private val timeOutList = listOf(
		10000L, 4000L, 1000L, 200L, 200L, 100L, 100L, 100L, 100L, 50L,
		5L, 50L, 4000L, 50L, 50L, 1000L, 50L, 50L, 5L, 10000L
	)


	@Test
	fun threadPoolRunTasks() {
		val threadPool = ThreadPool(1000)
		var taskCount = 0

		for (i in 0..repeatTaskCreation) {
			for (j in 0 until timeOutList.size) {
				threadPool.addTask(DelayTask("$taskCount", timeOutList[j]))
				taskCount++
			}
		}

		val threadPoolTook = threadPool.waitToFinish()
		println("ThreadPool took $threadPoolTook ms to execute $taskCount tasks")
	}
}
