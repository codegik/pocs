package com.codegik.poc.threadpool.pool

import com.codegik.poc.threadpool.Task
import com.codegik.poc.threadpool.thread.ReusableThread
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListMap

class ThreadPool(
    private val maxSimultaneous: Int = 5
) {
    private val threads = ConcurrentHashMap<Long, ReusableThread>()
    private val tasks = ConcurrentSkipListMap<String, Task>()
    private val startedAt = System.currentTimeMillis()

    init {
        for (i in 1..maxSimultaneous) {
            val thread = ReusableThread("reusable-thread-$i", this)
            threads[thread.id] = thread
            threads[thread.id]!!.start()
        }
    }


    fun addTask(task: Task) {
        tasks[task.name()] = task
    }


    fun removeThread(reusableThread: ReusableThread) {
        threads.remove(reusableThread.id)
    }


    fun findQueuedTask(): Task? {
        return tasks.pollFirstEntry()?.value
    }


    fun waitToFinish(): Long {
        while (threads.isNotEmpty()) {
            if (tasks.isEmpty()) {
                threads.forEach { it.value.stopLookingForTasks() }
            }
            Thread.sleep(1)
        }

        return System.currentTimeMillis() - startedAt
    }
}
