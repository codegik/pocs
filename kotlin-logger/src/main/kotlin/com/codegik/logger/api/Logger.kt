package com.codegik.logger.api

interface Logger {
    fun info(message: String)
    fun debug(message: String)
    fun error(message: String)
}