package com.codegik.poc.threadpool.thread

import com.codegik.poc.threadpool.Task
import com.codegik.poc.threadpool.pool.SmartPool

class SmartThread(private val task: Task, private val smartPool: SmartPool): Thread("smart-thread-${task.name()}") {

    override fun run() {
        task.execute()
        smartPool.remove(this)
    }
}