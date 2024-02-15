package com.codegik.logger.appender

import com.codegik.logger.api.Logger
import com.codegik.logger.config.LoggerConfig
import java.io.File
import java.time.LocalDate
import kotlin.concurrent.thread

class FileSystemLogger(private val klass: Class<*>): Logger {

    override fun info(message: String) {
        writeMessage(message, "INFO")
    }

    override fun debug(message: String) {
        writeMessage(message, "DEBUG")
    }

    override fun error(message: String) {
        writeMessage(message, "ERROR")
    }

    private fun writeMessage(message: String, level: String) {
        if (LoggerConfig.isAsync()) {
            writeAsync(message, level)
        } else {
            write(message, level)
        }
    }

    private fun writeAsync(message: String, level: String) {
        thread {
            write(message, level)
        }
    }

    private fun write(message: String, level: String) {
        val fullMessage = "[${LocalDate.now()}] [$level] [${klass.name}] $message"
        File(LoggerConfig.fileName()).appendText(fullMessage, Charsets.UTF_8)
    }
}