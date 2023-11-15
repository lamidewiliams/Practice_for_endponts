package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Service
public class studentservice {

    private  final  StudentRepository studentRepository;
    @Autowired
    public studentservice(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addNewStudent(student Student) {
        StudentRepository.findstudentByemail(student.getemail());
        System.out.println(Student);
    }

    public List<student> getStudent(){
       return studentRepository.findAll();
    }

}
