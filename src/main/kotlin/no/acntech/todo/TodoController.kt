package no.acntech.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController {

    @GetMapping("todo")
    fun findAll(): List<Todo> {
        val value1 = Todo(1L, "value1", true)
        val value2 = Todo(2L, "value2", false)
        return listOf(value1, value2)
    }

    @GetMapping("todo/{id}")
    fun find(@PathVariable id: String): Todo {
        return Todo(id.toLongOrNull(), id, true)
    }
}