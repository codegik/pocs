package com.codegik.poc.threadpool

import com.codegik.poc.threadpool.pool.ThreadPool
import com.codegik.poc.threadpool.task.DelayTask

class App

fun main(args: Array<String>) {

	val threadPool = ThreadPool("custom-task-manager", 3)

	for (i in 1..10) {
		threadPool.addTask(DelayTask(name = "delay-task-$i", 4000))
	}

	threadPool.waitToFinish()
}
