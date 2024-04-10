package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }
    @GetMapping("/String")
    public String homePage(){
        return "this is my home page";
    }

    @GetMapping ("/all_student")
    public List<Student> getStudent() {
        return studentservice.getStudent();
    }

    @PostMapping("/add-student")
    public Student registerNewStudent(@RequestBody StudentDTO studentDTO) {
        return studentservice.addNewStudent(studentDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
       studentservice.deleteThestudent(id);
    }
    @PutMapping(path = "{id}")
    public  void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentservice.updateStudent(id,name,email);
    }

}
