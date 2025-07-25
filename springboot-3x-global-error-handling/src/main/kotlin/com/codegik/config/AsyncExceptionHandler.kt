package com.codegik.config

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import java.lang.reflect.Method
import java.util.logging.Logger

class AsyncExceptionHandler : AsyncUncaughtExceptionHandler {

    private val logger = Logger.getLogger(AsyncExceptionHandler::class.java.name)

    override fun handleUncaughtException(ex: Throwable, method: Method, vararg params: Any?) {
        logger.severe("Uncaught async exception in method: ${method.name}")
        logger.severe("Exception: ${ex.message}")
        logger.severe("Method params: ${params.contentToString()}")

        // Here you can:
        // 1. Send alerts/notifications
        // 2. Store error in database
        // 3. Publish to message queue
        // 4. Update metrics/monitoring

        when (ex) {
            is IllegalArgumentException -> {
                logger.warning("Invalid argument in async method: ${ex.message}")
                // Handle specific exception type
            }
            is RuntimeException -> {
                logger.severe("Runtime exception in async method: ${ex.message}")
                // Handle runtime exceptions
            }
            else -> {
                logger.severe("Unexpected exception in async method: ${ex.message}")
                // Handle other exceptions
            }
        }
    }
}
