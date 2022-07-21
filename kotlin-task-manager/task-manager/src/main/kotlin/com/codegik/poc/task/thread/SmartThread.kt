package com.codegik.poc.task.thread

import com.codegik.poc.task.Task
import com.codegik.poc.task.pool.TaskPool

class SmartThread(private val task: Task, private val taskPool: TaskPool): Thread(task.name()) {

    override fun run() {
        println("Started task $name")
        task.execute()
        println("Finished task $name")
        taskPool.remove(this)
    }
}