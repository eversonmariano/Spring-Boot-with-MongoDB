package com.evermariano.SBMongoDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;

@SpringBootApplication
public class SpringBootWithMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithMongoDbApplication.class, args);
    }


    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new  Address(
                    "Brasil",
                    "58410-000",
                    "Campina Grande"
            );

            Student student = new Student(
                    "Everson",
                    "mariano",
                    "everson@gmail.com",
                    address,
                    Gender.MALE,
                    List.of("Engenharia de Computação"),
                    BigDecimal.TEN,
                    LocalDateTime.now()

            );

            repository.insert(student);


        };
    }
}
