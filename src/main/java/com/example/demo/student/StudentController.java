package com.example.demo.student;

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

    @GetMapping
    public List<Student> getStudent() {
        return studentservice.getStudent();
    }

    @PostMapping
    public Student registerNewStudent(@RequestBody StudentDTO studentDTO) {
        return studentservice.addNewStudent(studentDTO);
    }

    @DeleteMapping(path = "{id}")
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
