package no.acntech.todo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

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

    @PostMapping("todo")
    fun create(@RequestBody description: String, uri: UriComponentsBuilder): ResponseEntity<String> {
        val save = todoRepository.save(Todo(description = description))
        val path = uri.path("todo/${save.id}").build().toUri()
        return ResponseEntity.created(path).build()
    }

    @PutMapping("todo/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody body: Todo): ResponseEntity<Todo> {
        val optionalTodo = todoRepository.findById(id)

        if (optionalTodo.isPresent) {
            val todo = optionalTodo.get()
            todo.description = body.description
            todo.isDone = body.isDone
            val updatedTodo = todoRepository.save(todo)
            return ResponseEntity.ok(updatedTodo)
        }
        return ResponseEntity.notFound().build()
    }
}