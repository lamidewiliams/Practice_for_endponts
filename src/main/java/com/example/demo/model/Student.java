package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
@Entity
@Table /*(name = "studentstable")*/
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id,
                   String name,
                   String email,
                   LocalDate DateOfBirth
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = DateOfBirth;

    }

    public Student(String name,
                   String email,
                   LocalDate DateOfBirth
    ) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = DateOfBirth;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
