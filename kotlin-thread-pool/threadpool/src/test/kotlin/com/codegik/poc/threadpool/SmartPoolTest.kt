package com.codegik.poc.threadpool

import com.codegik.poc.threadpool.pool.SmartPool
import org.junit.jupiter.api.Test

class SmartPoolTest {

	@Test
	fun add3Tasks() {
		val smartPool = SmartPool()

		smartPool.add(DelayTask("1", 10000))
		smartPool.add(DelayTask("2", 4000))
		smartPool.add(DelayTask("3", 1000))

		smartPool.waitToFinish()
	}


	@Test
	fun add10Tasks() {
		val smartPool = SmartPool()

		smartPool.add(DelayTask("1", 10000))
		smartPool.add(DelayTask("2", 4000))
		smartPool.add(DelayTask("3", 1000))
		smartPool.add(DelayTask("4", 1000))
		smartPool.add(DelayTask("5", 20000))
		smartPool.add(DelayTask("6", 1000))
		smartPool.add(DelayTask("7", 1000))
		smartPool.add(DelayTask("8", 1000))
		smartPool.add(DelayTask("9", 1000))
		smartPool.add(DelayTask("10", 500))

		smartPool.waitToFinish()
	}


	@Test
	fun add50Tasks() {
		val smartPool = SmartPool()

		for (i in 0..50) {
			smartPool.add(DelayTask("$i", 500))
		}

		smartPool.waitToFinish()
	}


	@Test
	fun add1000Tasks() {
		val smartPool = SmartPool(maxSimultaneous = 15)

		for (i in 0..1000) {
			smartPool.add(DelayTask("$i", 200))
		}

		smartPool.waitToFinish()
	}
}
