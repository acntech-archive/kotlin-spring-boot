package no.acntech.todo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class TodoApplication {

    @Bean
    open fun init(repository: TodoRepository) = CommandLineRunner {
        repository.save(Todo(1L, "Tømme oppvaskmaskinen", true))
        repository.save(Todo(2L, "Vask leilighet", true))
        repository.save(Todo(3L, "Lære kotlin", false))
        repository.save(Todo(4L, "Drikke", false))
        repository.save(Todo(5L, "Kjøp en spabehandling", false))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(TodoApplication::class.java, *args)
}


