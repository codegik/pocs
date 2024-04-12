package com.codegik.poc.service

import com.codegik.poc.config.WebSocketHandler
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class MessageService {
    private val logger = LoggerFactory.getLogger(WebSocketHandler::class.java)
    private var textMessage = ""

    fun get(): String {
        logger.info("Client requesting message")
        return textMessage
    }

    fun waitForMessage(): String {
        while (textMessage.isEmpty()) {
            Thread.sleep(1000)
            logger.info("Client waiting for message")
        }
        return textMessage
    }

    fun update(textMessage: String) {
        logger.info("Client updating message")
        this.textMessage = textMessage
    }

    fun delete() {
        logger.info("Client deleting message")
        this.textMessage = ""
    }
}