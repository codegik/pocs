package com.codegik.poc.threadpool

interface Task {
    fun name(): String
    fun execute()
}
