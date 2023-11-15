package com.example.demo.student;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Setter
@Getter
@Entity
@Table /*(name = "studentstable")*/
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private   String email;
    private LocalDate DateOfBirth;
    @Transient
    private Integer Age;

    public student() {
    }
    public student(Long id,
                   String name,
                   String email,
                   LocalDate DateOfBirth
                   ) {
        this.id = id;
        this.name = name;
        this.email=email;
        this.DateOfBirth=DateOfBirth;

    }
    public student(String name,
                   String email,
                   LocalDate DateOfBirth
                   ) {
        this.name = name;
        this.email=email;
        this.DateOfBirth=DateOfBirth;

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public  String getemail() {
        return email;
    }

    public  void setemail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.DateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return Period.between(this.DateOfBirth,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.Age = age;
    }
}
