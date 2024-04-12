package com.codegik.poc.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.lang.Thread.sleep
import java.time.Instant.now


@Controller
@RequestMapping("/")
class PollingController {

    private var textMessage = ""


    @GetMapping("/message")
    fun get(): ResponseEntity<String> {
        return if (textMessage.isEmpty()) {
            ResponseEntity.notFound().build()
        } else {
            ResponseEntity.ok("$textMessage ${now()}")
        }
    }


    @PostMapping("/message")
    fun update(@RequestBody textMessage: String): ResponseEntity<Void> {
        this.textMessage = textMessage
        return ResponseEntity.ok().build()
    }


    @DeleteMapping("/message")
    fun delete(): ResponseEntity<Void> {
        this.textMessage = ""
        return ResponseEntity.ok().build()
    }


    @GetMapping("/wait-for-message")
    fun getLongPolling(): ResponseEntity<String> {
        while (true) {
            if (textMessage.isNotEmpty()) {
                return ResponseEntity.ok("$textMessage ${now()}")
            }
            sleep(1000)
        }
    }
}