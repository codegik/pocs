package com.codegik.poc.threadpool

import com.codegik.poc.threadpool.pool.SmartPool
import com.codegik.poc.threadpool.pool.ThreadPool
import org.junit.jupiter.api.Test

class PoolTest {

	@Test
	fun smartPoolGoesFirstToRun3Tasks() {
		val timeOutList = listOf(10000L, 4000L, 1000L, 200L, 200L, 100L, 100L, 100L, 100L, 50L, 50L, 50L, 50L, 50L, 50L, 50L, 50L, 50L, 50L, 50L, 50L)
		val smartPool = SmartPool()

		var taskCount = 0
		for (i in 0..3) {
			for (j in 0 until timeOutList.size) {
				smartPool.addTask(DelayTask("$taskCount", timeOutList[j]))
				taskCount++
			}
		}

		val smartPoolTook = smartPool.waitToFinish()

		val threadPool = ThreadPool()

		for (i in 1..timeOutList.size) {
			threadPool.addTask(DelayTask("$i", timeOutList[i-1]))
		}

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

		smartPool.addTask(DelayTask("1", 10000))
		smartPool.addTask(DelayTask("2", 4000))
		smartPool.addTask(DelayTask("3", 1000))

		val smartPoolTook = smartPool.waitToFinish()

		println("SmartPool took $smartPoolTook")
		println("ThreadPool took $threadPoolTook")
	}

}
