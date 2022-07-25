package com.codegik.poc.task

import com.codegik.poc.task.pool.TaskPool

class App

fun main(args: Array<String>) {

	val taskPool = TaskPool("custom-task-manager", 3)

	for (i in 1..10) {
		taskPool.add(DelayTask(name = "delay-task-$i", 4000))
	}

	taskPool.waitToFinish()
}
