package com.codegik.poc.threadpool.thread

import com.codegik.poc.threadpool.pool.ThreadPool

class ReusableThread(private val threadName: String = "reusable-thread", private val threadPool: ThreadPool): Thread(threadName) {

    override fun run() {
        while (isInterrupted) {
            threadPool.findQueuedTask().let { task ->
                task?.let {
                    println("[$threadName] Started task ${it.name()}")
                    it.execute()
                    println("[$threadName] Finished task ${it.name()}")
                }
            }
        }

        threadPool.removeThread(this)
    }


    fun stopLookingForTasks() {
        interrupted()
    }
}