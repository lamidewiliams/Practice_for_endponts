package com.example.demo.dto;

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
