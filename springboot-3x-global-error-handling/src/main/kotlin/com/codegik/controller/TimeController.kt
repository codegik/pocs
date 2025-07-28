package com.codegik.controller

import com.codegik.service.TimeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api")
class TimeController {

    @Autowired
    private lateinit var timeService: TimeService

    @GetMapping("/current-time")
    fun processTime(): Map<String, Any> {
        val currentTime = LocalDateTime.now()

        timeService.processTime(currentTime)

        return mapOf(
            "currentTime" to currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        )
    }

    @GetMapping("/async-current-time-error")
    fun processAsyncWithError(): Map<String, Any> {
        val currentTime = LocalDateTime.now()

        timeService.processAsyncWithError(currentTime)

        // Should not reach here due to the async error
        return mapOf(
            "currentTime" to currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        )
    }

    @GetMapping("/async-current-time-error-big-decimal")
    fun processAsyncWithErrorBigDecimal(): Map<String, Any> {
        val currentTime = LocalDateTime.now()

        timeService.processAsyncWithErrorBigDecimal(currentTime)

        // Should not reach here due to the async error
        return mapOf(
            "currentTime" to currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        )
    }

    @GetMapping("/sync-current-time-error")
    fun processSyncWithError(): Map<String, Any> {
        val currentTime = LocalDateTime.now()

        timeService.processSyncWithError(currentTime)

        // Should not reach here due to the async error
        return mapOf(
            "currentTime" to currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        )
    }

    @GetMapping("/async-current-time-error-handler")
    fun processAsyncWithErrorHandler(): Map<String, Any> {
        val currentTime = LocalDateTime.now()

        timeService.processAsyncWithErrorHandler(currentTime)

        // Should not reach here due to the async error
        return mapOf(
            "currentTime" to currentTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        )
    }
}
