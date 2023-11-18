package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.AUGUST;
import static java.util.Calendar.MARCH;

@Configuration

public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return  args -> {
            Student ola = new Student(
                            "Olamide",
                            "olamide.will@gmail.com",
                            LocalDate.of(1992 , AUGUST,6)

            );
            Student Bukola = new Student(
                    "Bukola",
                    "buks@gmail.com",
                    LocalDate.of(2001 , MARCH,8)

            );
            Student Dragon = new Student(
                    "Drake",
                    "drakinson.fire@gmail.com",
                    LocalDate.of(323 , MARCH,8)

            );
            repository.saveAll(
                    List.of(Dragon,Bukola,ola)
            );

        };
    }
}
