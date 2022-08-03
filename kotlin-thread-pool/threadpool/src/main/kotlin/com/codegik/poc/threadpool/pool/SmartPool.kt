package com.codegik.poc.threadpool.pool

import com.codegik.poc.threadpool.Task
import com.codegik.poc.threadpool.thread.SmartThread
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class SmartPool(
    private val name: String = "smart-pool",
    private val maxSimultaneous: Int = 5
) {
    private val threads = mutableSetOf<SmartThread>()
    private var aliveThreadCount = 0
    private val lock = ReentrantLock()
    private val startedAt = System.currentTimeMillis()


    fun addTask(task: Task) {
        val thread = SmartThread(task, this)
        threads.add(thread)

        if (aliveThreadCount < maxSimultaneous) {
            aliveThreadCount++
            thread.start()
        }
    }


    fun remove(smartThread: SmartThread) {
        lock.withLock {
            threads.remove(smartThread)
            aliveThreadCount--

            if (aliveThreadCount < maxSimultaneous) {
                threads.firstOrNull { !it.isAlive || it.isInterrupted }?.start()
            }
        }
    }


    fun waitToFinish(): Long {
        while (threads.isNotEmpty()) {
            Thread.sleep(1)
        }

        return System.currentTimeMillis() - startedAt
    }
}
