package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.dto.StudentDTO;

import java.util.List;


public interface StudentService {

    void deleteThestudent(Long id);

    void updateStudent( Long id,String name,String email);

    Student addNewStudent(StudentDTO studentDTO);

    List<Student> getStudent();

}
