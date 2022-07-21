package com.codegik.poc.task

class SimpleTask(private val name: String = "simple-task", private val timeout: Long = 5000) : Task {

    override fun name(): String {
        return name
    }

    override fun execute() {
        Thread.sleep(timeout)
    }
}