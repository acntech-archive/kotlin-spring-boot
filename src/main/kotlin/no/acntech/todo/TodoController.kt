package no.acntech.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping("todo")
    fun findAll(): List<Todo> {
        return todoRepository.findAll().toList()
    }

    @GetMapping("todo/{id}")
    fun find(@PathVariable id: Long): Todo? {
        return todoRepository.findById(id).orElse(null)
    }
}