package com.example.demo.student;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;


public interface StudentService {

    void deleteThestudent(Long id);

    void updateStudent( Long id,String name,String email);

    Student addNewStudent(StudentDTO studentDTO);

    List<Student> getStudent();

}
