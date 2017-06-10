package no.acntech.todo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters

@SpringBootApplication
@EntityScan(basePackageClasses = arrayOf(Jsr310JpaConverters::class),
        basePackages = arrayOf("no.acntech.todo"))
class TodoApplication {

    @Bean
    open fun init(repository: TodoRepository) = CommandLineRunner {
        repository.save(Todo(id = 1L, description = "Tømme oppvaskmaskinen", done = true))
        repository.save(Todo(id = 2L, description = "Vask leilighet", done = true))
        repository.save(Todo(id = 3L, description = "Lære kotlin", done = false))
        repository.save(Todo(id = 4L, description = "Drikke", done = false))
        repository.save(Todo(id = 5L, description = "Kjøp en spabehandling", done = false))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(TodoApplication::class.java, *args)
}


