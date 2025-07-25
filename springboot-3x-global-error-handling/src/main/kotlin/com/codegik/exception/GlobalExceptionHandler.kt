package com.codegik.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime
import java.util.logging.Logger

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = Logger.getLogger(GlobalExceptionHandler::class.java.name)

    @ExceptionHandler(RuntimeException::class)
    fun handleGlobalException(ex: RuntimeException, request: WebRequest): ResponseEntity<ErrorResponse> {
        logger.severe("Global exception caught: ${ex.message}")

        val errorResponse = ErrorResponse(
            timestamp = LocalDateTime.now(),
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = "Caught by GlobalExceptionHandler",
            message = ex.message ?: "An unexpected error occurred",
            path = request.getDescription(false).removePrefix("uri=")
        )

        return ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}

data class ErrorResponse(
    val timestamp: LocalDateTime,
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)
