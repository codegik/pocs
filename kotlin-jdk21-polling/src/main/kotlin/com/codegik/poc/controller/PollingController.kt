package com.codegik.poc.controller

import com.codegik.poc.config.WebSocketHandler
import com.codegik.poc.service.MessageService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URLDecoder.decode
import java.time.Instant.now
import kotlin.text.Charsets.UTF_8


@Controller
@RequestMapping("/")
class PollingController(
    private val messageService: MessageService,
    private val webSocketHandler: WebSocketHandler
) {

    @GetMapping("/message")
    fun get(): ResponseEntity<String> {
        return if (messageService.get().isEmpty()) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok("${now()}: ${messageService.get()}")
        }
    }


    @PostMapping("/message")
    fun update(@RequestBody textMessage: String): ResponseEntity<Void> {
        val message = decode(textMessage, UTF_8.name()).removeSuffix("=")
        messageService.update(message)
        return ResponseEntity.ok().build()
    }


    @PostMapping("/broadcast-message")
    fun broadcast(@RequestBody textMessage: String): ResponseEntity<Void> {
        val message = decode(textMessage, UTF_8.name())
        messageService.update(message)
        webSocketHandler.broadcastMessage(message)
        return ResponseEntity.ok().build()
    }


    @DeleteMapping("/message")
    fun delete(): ResponseEntity<Void> {
        messageService.delete()
        return ResponseEntity.ok().build()
    }


    @GetMapping("/wait-for-message")
    fun getLongPolling(): ResponseEntity<String> {
        return ResponseEntity.ok(messageService.waitForMessage())
    }
}