package com.codegik.dontpad.controller

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/")
class HealthController {

    @GetMapping("/healthz")
    fun health(): ResponseEntity<Void> {
        return ResponseEntity.ok().build<Void>()
    }

}