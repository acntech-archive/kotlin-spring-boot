package no.acntech.todo

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : CrudRepository<Todo, Long> {

    fun findByIsDone(done: Boolean): Iterable<Todo>

}
