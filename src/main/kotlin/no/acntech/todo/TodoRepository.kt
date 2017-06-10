package no.acntech.todo

import org.springframework.stereotype.Repository

@Repository
class TodoRepository {

    fun findAll(): List<Todo> {
        val value1 = Todo(1L, "value1", true)
        val value2 = Todo(2L, "value2", false)
        return listOf(value1, value2)
    }

    fun find(id: String): Todo {
        return Todo(id.toLongOrNull(), id, true)
    }
}
