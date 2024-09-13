package com.in28min.rest.webservices.todo.config;

import com.in28min.rest.webservices.todo.entity.TodoEntity;
import com.in28min.rest.webservices.todo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TodoRepository todoRepository) {
        return  args -> {
            log.info("Preloading " + todoRepository.save(new TodoEntity("Learn Java", true, new Date(), "natalia")));
            log.info("Preloading " + todoRepository.save(new TodoEntity("Learn Angular", false, new Date(), "natalia")));
            log.info("Preloading " + todoRepository.save(new TodoEntity("Learn Spring Boot", false, new Date(), "natalia")));
            log.info("Preloading " + todoRepository.save(new TodoEntity("Study Docker", false, new Date(), "in28min")));
            log.info("Preloading " + todoRepository.save(new TodoEntity("Visit USA", false, new Date(), "in28min")));
            log.info("Preloading " + todoRepository.save(new TodoEntity("Visit Wien", false, new Date(), "in28min")));
        };
    }
}
