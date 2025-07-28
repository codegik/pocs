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

        throw ex // Re-throwing the exception to ensure it is logged and handled properly
    }
}
