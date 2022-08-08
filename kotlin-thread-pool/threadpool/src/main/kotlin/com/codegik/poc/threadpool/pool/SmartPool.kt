package com.codegik.poc.threadpool.pool

import com.codegik.poc.threadpool.Task
import com.codegik.poc.threadpool.thread.SmartThread
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListMap

class SmartPool(
    private val maxSimultaneous: Int = 5
) {
    private val threads = ConcurrentSkipListMap<String, SmartThread>()
    private var aliveThreadCount = 0
    private val startedAt = System.currentTimeMillis()


    fun addTask(task: Task) {
        val thread = SmartThread(task, this)
        threads[thread.name] = thread

        if (aliveThreadCount < maxSimultaneous) {
            aliveThreadCount++
            thread.start()
        }
    }


    fun remove(smartThread: SmartThread) {
            threads.remove(smartThread.name)
            aliveThreadCount--

            if (aliveThreadCount < maxSimultaneous) {
                threads.forEach {
                    if (it.value.state == Thread.State.NEW && !it.value.isAlive) {
                        it.value.start()
                        return
                    }
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
