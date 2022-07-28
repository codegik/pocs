package com.codegik.poc.threadpool.thread

import com.codegik.poc.threadpool.pool.ThreadPool

class ReusableThread(threadName: String = "reusable-thread", private val threadPool: ThreadPool): Thread(threadName) {
    private var lookingForTasks = true


    override fun run() {
        while (lookingForTasks) {
            threadPool.findQueuedTask().let { task ->
                if (task != null) {
                    println("[$name] Started task ${task.name()}")
                    task.execute()
                    println("[$name] Finished task ${task.name()}")
                }
            }
        }

        threadPool.removeThread(this)
    }


    fun stopLookingForTasks() {
        lookingForTasks = false
    }
}
