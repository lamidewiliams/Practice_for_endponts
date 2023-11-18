package com.example.demo.student;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class StudentDTO {
    private String name;
    private String email;
    private String dateOfBirth;
}
