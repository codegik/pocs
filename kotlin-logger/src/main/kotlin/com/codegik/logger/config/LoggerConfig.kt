package com.codegik.logger.config

import java.util.*

object LoggerConfig {
    private val properties = Properties()

    init {
        val file = this::class.java.classLoader.getResourceAsStream("application.properties")
        properties.load(file)
    }

    fun fileName(): String = properties.getProperty("logger.fileName", "application.log")

    fun isAsync(): Boolean = properties.getProperty("logger.isAsync", "true").toBoolean()

    fun appenders(): Array<String> {
        val appenders = properties.getProperty("logger.appenders", "")
        return if (appenders.isEmpty()) arrayOf() else appenders.split(',').toTypedArray()
    }
}
