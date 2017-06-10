package no.acntech.todo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Todo(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,
        var text: String? = null,
        var isDone: Boolean? = null)
