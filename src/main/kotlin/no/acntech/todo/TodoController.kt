package no.acntech.todo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoController(val todoRepository: TodoRepository) {

    @GetMapping("todo")
    fun findAll(): List<Todo> {
        return todoRepository.findAll().toList()
    }

    @GetMapping("todo/{id}")
    fun find(@PathVariable id: Long): ResponseEntity<Todo> {
        val todo = todoRepository.findById(id)
        if (todo.isPresent) {
            return ResponseEntity.ok(todo.get())
        } else {
            return ResponseEntity.notFound().build()
        }
    }

    @GetMapping("todo/search")
    fun search(@RequestParam(required = false) done: Boolean?): List<Todo> {
        if (done != null) {
            return todoRepository.findByIsDone(done).toList()
        } else {
            return todoRepository.findAll().toList()
        }
    }
}