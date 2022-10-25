package com.codegik.poc.javaresilience4j.controller

import com.codegik.poc.javaresilience4j.domain.Chair
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chair")
class ChairController {
    private val chairList = listOf(
        Chair("1", "Table chair", 30, 50),
        Chair("2", "Outside chair", 100, 80),
        Chair("3", "Weird chair", 100, 20)
    )

    @GetMapping
    fun allChairs(): ResponseEntity<List<Chair>> {
        return ResponseEntity.ok(chairList)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): ResponseEntity<Chair> {
        return ResponseEntity.ok(chairList.filter { chair -> id == chair.id }.firstOrNull())
    }
}