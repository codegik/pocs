package com.codegik.controller

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/log")
class LogController {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/{count}")
    fun logging(@PathVariable count: Int): ResponseEntity<String> {

        for (i in 0..count) {
            logger.info("Generating async log message [$i/$count] ${UUID.randomUUID()}")
        }

        return ok().build()
    }

}