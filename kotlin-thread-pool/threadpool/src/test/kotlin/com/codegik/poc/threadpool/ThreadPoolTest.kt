package com.codegik.poc.threadpool

import com.codegik.poc.threadpool.pool.ThreadPool
import org.junit.jupiter.api.Test

class ThreadPoolTest {

	@Test
	fun add3Tasks() {
		val threadPool = ThreadPool()

		threadPool.addTask(DelayTask("1", 10000))
		threadPool.addTask(DelayTask("2", 4000))
		threadPool.addTask(DelayTask("3", 1000))

		threadPool.waitToFinish()
	}

}
