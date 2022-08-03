package com.codegik.poc.threadpool.pool

import com.codegik.poc.threadpool.Task
import com.codegik.poc.threadpool.thread.ReusableThread
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class ThreadPool(
    private val name: String = "thread-pool",
    private val maxSimultaneous: Int = 5
) {
    private val threads = mutableMapOf<Long, ReusableThread>()
    private val tasks = mutableSetOf<Task>()
    private val lock = ReentrantLock()
    private val startedAt = System.currentTimeMillis()

    init {
        for (i in 1..maxSimultaneous) {
            val thread = ReusableThread("reusable-thread-$i", this)
            threads[thread.id] = thread
            threads[thread.id]!!.start()
        }
    }


    fun addTask(task: Task) {
        tasks.add(task)
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

        return System.currentTimeMillis() - startedAt
    }
}
