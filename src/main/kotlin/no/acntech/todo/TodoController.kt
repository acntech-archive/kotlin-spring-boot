package no.acntech.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController {

    @GetMapping("todo")
    fun findAll(): List<String> {
        return listOf("a", "b", "c")
    }

    @GetMapping("todo/{id}")
    fun find(@PathVariable id: String): String {
        return id
    }
}