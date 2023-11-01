package com.codegik.dontpad.controller

import com.codegik.dontpad.service.DontpadService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

data class Todo(val id: Int, val title: String)

@Controller
@RequestMapping("/")
class DontpadView(val dontpadService: DontpadService) {

    @GetMapping
    fun index(): String {
        return "index"
    }


    @GetMapping("/dontpad/{dontpadName}")
    fun dontpad(@PathVariable("dontpadName") dontpadName: String, model: Model): String {

        dontpadService.create(dontpadName)
        model["dontpadName"] = dontpadName
        model["dontpadValue"] = dontpadService.value(dontpadName)

        return "dontpad"
    }


    @PostMapping("/dontpad")
    fun create(@RequestParam("dontpadName") dontpadName: String,
               response: HttpServletResponse): String {

        if (dontpadService.create(dontpadName)) {
            response.addHeader("HX-Redirect", "/dontpad/$dontpadName")
        }

        return "";
    }


    @PostMapping("/dontpad/{dontpadName}")
    @ResponseBody
    fun update(@PathVariable("dontpadName") dontpadName: String,
               @RequestParam("dontpadValue") dontpadValue: String): String {

        dontpadService.update(dontpadName, dontpadValue)

        return "";
    }
}