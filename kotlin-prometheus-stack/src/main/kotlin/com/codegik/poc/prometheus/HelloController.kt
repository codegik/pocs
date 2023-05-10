package com.codegik.poc.prometheus

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    private var requests = 0

    @GetMapping("/hello")
    fun hello() = ++requests
}