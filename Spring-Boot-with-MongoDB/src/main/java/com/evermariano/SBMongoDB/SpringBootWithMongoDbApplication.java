package com.evermariano.SBMongoDB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import java.util.List;

@SpringBootApplication

public class SpringBootWithMongoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithMongoDbApplication.class, args);


    }




    CommandLineRunner runner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {

        return args -> {
            Address address = new Address(
                    "England",
                    "London",
                    "NW9"
            );

            String email = "naberayed@gmail.com";
            Student student = new Student(
                    "Ayed",
                    "Naber",
                    email,
                    address,
                    Gender.MALE,
                    List.of("Computer Science", "math"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );
                studentRepository.findStudentByEmail(email)
                    .ifPresentOrElse(s -> {
                        System.out.println(s + " already exists");
                    }, () -> {
                        System.out.println("Inserting student " + student);
                        studentRepository.insert(student);
                    });







        };
    }
}

