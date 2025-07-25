package com.codegik.service

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.logging.Logger

@Service
class TimeService {

    private val logger = Logger.getLogger(TimeService::class.java.name)


    fun processTime(currentTime: LocalDateTime) {
        logger.info("Sync processing completed for time: $currentTime")
    }


    @Async("taskExecutor")
    fun processAsyncWithError(currentTime: LocalDateTime) {
        logger.info("processAsyncWithError completed for time: $currentTime")
         throw RuntimeException("Simulated async error")
    }


    fun processSyncWithError(currentTime: LocalDateTime) {
        logger.info("processSyncWithError completed for time: $currentTime")
        throw RuntimeException("Simulated sync error")
    }


    @Async("taskExecutorExceptionHandler")
    fun processAsyncWithErrorHandler(currentTime: LocalDateTime) {
        logger.info("processAsyncWithError completed for time: $currentTime")
        throw RuntimeException("Simulated async error with handler")
    }
}
