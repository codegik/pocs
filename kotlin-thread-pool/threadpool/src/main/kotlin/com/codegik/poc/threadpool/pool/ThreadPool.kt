package com.codegik.poc.threadpool.pool

import com.codegik.poc.threadpool.Task
import com.codegik.poc.threadpool.thread.ReusableThread
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class ThreadPool(private val name: String = "thread-pool", size: Int = 5) {
    private val threads = mutableMapOf<Long, ReusableThread>()
    private val tasks = mutableSetOf<Task>()
    private val lock = ReentrantLock()
    private val startedAt = System.currentTimeMillis()

    init {
        for (i in 1..size) {
            val thread = ReusableThread("reusable-thread-$i", this)
            threads[thread.id] = thread
            threads[thread.id]!!.start()
        }
    }


    fun addTask(task: Task) {
        tasks.add(task)
        println("[$name] Queued task ${task.name()}")
    }


    fun removeThread(reusableThread: ReusableThread) {
        lock.withLock {
            threads.remove(reusableThread.id)
        }
    }


    fun findQueuedTask(): Task? {
        lock.withLock {
            val task = tasks.firstOrNull()
            tasks.remove(task)
            return task
        }
    }


    fun waitToFinish(): Long {
        while (threads.isNotEmpty()) {
            lock.withLock {
                if (tasks.isEmpty()) {
                    threads.forEach { it.value.stopLookingForTasks() }
                }
            }
            Thread.sleep(1)
        }

        val took = System.currentTimeMillis() - startedAt
        println("[$name] took $took to finish")

        return took
    }
}
