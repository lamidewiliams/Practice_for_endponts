package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.AUGUST;
import static java.util.Calendar.MARCH;

@Configuration

public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return  args -> {
            student ola = new student(
                            "Olamide",
                            "olamide.will@gmail.com",
                            LocalDate.of(1992 , AUGUST,6)

            );
            student Bukola = new student(
                    "Bukola",
                    "buks@gmail.com",
                    LocalDate.of(2001 , MARCH,8)

            );
            student Dragon = new student(
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
