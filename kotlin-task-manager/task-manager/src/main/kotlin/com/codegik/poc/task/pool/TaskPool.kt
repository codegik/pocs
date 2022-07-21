package com.codegik.poc.task.pool

import com.codegik.poc.task.Task
import com.codegik.poc.task.thread.SmartThread
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class TaskPool(private val name: String = "task-pool", private val maxSimultaneous: Int = 5) {
    private val threads = arrayListOf<SmartThread>()
    private var aliveThreadCount = 0
    private val lock = ReentrantLock()


    fun add(task: Task) {
        val thread = SmartThread(task, this)
        threads.add(thread)

        if (aliveThreadCount < maxSimultaneous) {
            aliveThreadCount++
            thread.start()
            println("Added task ${thread.name}")
        } else {
            println("Queued task ${thread.name}")
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


    fun waitToFinish() {
        while (threads.size > 0) {
            Thread.sleep(1)
        }
    }
}