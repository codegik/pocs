package com.codegik.poc.task

class DelayTask(private val name: String = "delay-task", private val timeout: Long = 5000) : Task {

    override fun name(): String {
        return name
    }

    override fun execute() {
        Thread.sleep(timeout)
    }
}