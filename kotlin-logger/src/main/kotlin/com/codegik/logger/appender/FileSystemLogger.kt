package com.codegik.logger.appender

import com.codegik.logger.api.Logger
import com.codegik.logger.config.LoggerConfig
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.io.File
import java.time.LocalDate

@Component
class FileSystemLogger(val loggerConfig: LoggerConfig): Logger {

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
        if (loggerConfig.isAsync.booleanValue()) {
            writeAsync(message, level)
        } else {
            write(message, level)
        }
    }

    @Async
    private fun writeAsync(message: String, level: String) {
        write(message, level)
    }

    private fun write(message: String, level: String) {
        val fullMessage = "[${LocalDate.now()}] [$level] $message"
        File(loggerConfig.fileName).appendText(fullMessage, Charsets.UTF_8)
    }
}