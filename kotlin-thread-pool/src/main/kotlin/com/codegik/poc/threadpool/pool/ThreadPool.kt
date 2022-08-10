package com.codegik.poc.threadpool.pool

import com.codegik.poc.threadpool.task.Task
import com.codegik.poc.threadpool.thread.ReusableThread
import java.util.concurrent.ConcurrentLinkedQueue

class ThreadPool(
    private val maxSimultaneous: Int = 5
) {
    private val threads = ConcurrentLinkedQueue<ReusableThread>()
    private val tasks = ConcurrentLinkedQueue<Task>()
    private val startedAt = System.currentTimeMillis()

    init {
        for (i in 1..maxSimultaneous) {
            val thread = ReusableThread("reusable-thread-$i", this)
            threads.add(thread)
            thread.start()
        }
    }


    fun addTask(task: Task) {
        tasks.add(task)
    }


    fun removeThread(reusableThread: ReusableThread) {
        threads.remove(reusableThread)
    }


    fun findQueuedTask(): Task? {
        return tasks.poll()
    }


    fun waitToFinish(): Long {
        while (threads.isNotEmpty()) {
            if (tasks.isEmpty()) {
                threads.forEach { it.stopLookingForTasks() }
            }
            Thread.sleep(1)
        }

        return System.currentTimeMillis() - startedAt
    }
}
