package com.codegik.poc.threadpool

import com.codegik.poc.threadpool.pool.SmartPool
import com.codegik.poc.threadpool.pool.ThreadPool
import org.junit.jupiter.api.Test

class PoolTest {

	@Test
	fun smartPoolGoesFirstToRun3Tasks() {
		val smartPool = SmartPool()

		smartPool.add(DelayTask("1", 10000))
		smartPool.add(DelayTask("2", 4000))
		smartPool.add(DelayTask("3", 1000))

		val smartPoolTook = smartPool.waitToFinish()

		val threadPool = ThreadPool()

		threadPool.addTask(DelayTask("1", 10000))
		threadPool.addTask(DelayTask("2", 4000))
		threadPool.addTask(DelayTask("3", 1000))

		val threadPoolTook = threadPool.waitToFinish()

		println("SmartPool took $smartPoolTook")
		println("ThreadPool took $threadPoolTook")
	}


	@Test
	fun threadPoolGoesFirstToRun3Tasks() {
		val threadPool = ThreadPool()

		threadPool.addTask(DelayTask("1", 10000))
		threadPool.addTask(DelayTask("2", 4000))
		threadPool.addTask(DelayTask("3", 1000))

		val threadPoolTook = threadPool.waitToFinish()

		val smartPool = SmartPool()

		smartPool.add(DelayTask("1", 10000))
		smartPool.add(DelayTask("2", 4000))
		smartPool.add(DelayTask("3", 1000))

		val smartPoolTook = smartPool.waitToFinish()

		println("SmartPool took $smartPoolTook")
		println("ThreadPool took $threadPoolTook")
	}

}
