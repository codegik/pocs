package com.codegik.poc.threadpool

import com.codegik.poc.threadpool.pool.SmartPool
import org.junit.jupiter.api.Test

class SmartPoolTest {

	@Test
	fun add3Tasks() {
		val smartPool = SmartPool()

		smartPool.addTask(DelayTask("1", 10000))
		smartPool.addTask(DelayTask("2", 4000))
		smartPool.addTask(DelayTask("3", 1000))

		smartPool.waitToFinish()
	}


	@Test
	fun add10Tasks() {
		val smartPool = SmartPool()

		smartPool.addTask(DelayTask("1", 10000))
		smartPool.addTask(DelayTask("2", 4000))
		smartPool.addTask(DelayTask("3", 1000))
		smartPool.addTask(DelayTask("4", 1000))
		smartPool.addTask(DelayTask("5", 20000))
		smartPool.addTask(DelayTask("6", 1000))
		smartPool.addTask(DelayTask("7", 1000))
		smartPool.addTask(DelayTask("8", 1000))
		smartPool.addTask(DelayTask("9", 1000))
		smartPool.addTask(DelayTask("10", 500))

		smartPool.waitToFinish()
	}


	@Test
	fun add50Tasks() {
		val smartPool = SmartPool()

		for (i in 0..50) {
			smartPool.addTask(DelayTask("$i", 500))
		}

		smartPool.waitToFinish()
	}


	@Test
	fun add1000Tasks() {
		val smartPool = SmartPool(maxSimultaneous = 15)

		for (i in 0..1000) {
			smartPool.addTask(DelayTask("$i", 200))
		}

		smartPool.waitToFinish()
	}
}
