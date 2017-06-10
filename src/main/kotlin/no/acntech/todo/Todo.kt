package no.acntech.todo

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Todo(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        var description: String? = null,
        var created: LocalDateTime? = LocalDateTime.now(),
        var done: Boolean? = false)
