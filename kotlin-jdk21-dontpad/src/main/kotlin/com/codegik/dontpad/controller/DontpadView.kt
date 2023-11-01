package com.codegik.dontpad.controller

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

data class Todo(val id: Int, val title: String)

@Controller
@RequestMapping("/")
class DontpadView {

    @GetMapping
    fun index(): String {
        return "index"
    }


    @GetMapping("/dontpad/{dontpad-name}")
    fun dontpad(@PathVariable("dontpad-name") dontpadName: String): String {
        return "dontpad"
    }


    @PostMapping("/dontpad")
    fun create(@RequestParam("dontpad-name") dontpadName: String, response: HttpServletResponse): String {
        response.addHeader("HX-Redirect", "/dontpad/$dontpadName")
        return "";
    }
}