package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")

public class studentController {
    private final studentservice Studentservice;
    @Autowired
    public studentController(studentservice Studentservice) {
        this.Studentservice = Studentservice;
    }

    @GetMapping
    public List<student> getStudent(){
       return Studentservice.getStudent();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody student Student){
        studentservice.addNewStudent(Student);
    }
}
