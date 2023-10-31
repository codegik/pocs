package com.codegik.dontpad.controller

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

data class Todo(val id: Int, val title: String)

@Controller
@RequestMapping("/todos")
class DontpadView {

    private var todos = mutableListOf(Todo(3, "Test"), Todo(4, "new one"))


    @GetMapping
    fun getAll(model: Model): String {
        model["todos"] = todos
        return "todos"
    }


    @DeleteMapping("/{id}", produces = [MediaType.TEXT_HTML_VALUE])
    fun delete(@PathVariable id: Int): String? {
        todos = todos.dropWhile { it.id == id }.toMutableList()
        println("Deleted $id")
        return null
    }
}