package com.example.TestTaskPryshchepa.db;

import com.example.TestTaskPryshchepa.models.User;
import com.example.TestTaskPryshchepa.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;


@Configuration
class LoadDB {

    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository){
        repository.save(new User("Oleh","Pryshchepa",LocalDate.of(2000,8,30)));
        repository.save(new User("Alex","Pryshchepa", LocalDate.of(1995,5,15)));
        repository.save(new User("Max","Pryshchepa", LocalDate.of(1970,10,5)));
        return args -> log.info("db load");
    }
}

