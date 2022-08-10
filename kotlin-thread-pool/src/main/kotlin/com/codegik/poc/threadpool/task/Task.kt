package com.codegik.poc.threadpool.task

interface Task {
    fun name(): String
    fun execute()
}
