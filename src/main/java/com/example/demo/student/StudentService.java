package com.example.demo.student;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public  void deleteTheStudent(Long id) {
        // to check if the student to be deleted exist
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("ID NOT Found!!");
        }
        studentRepository.deleteById(id);
    }

    public Student addNewStudent(StudentDTO studentDTO) {
        //logic to convert dto to entity
        Student student = new Student();

        //to copy properties
        BeanUtils.copyProperties(studentDTO, student);
        //to check if email already exist
        Optional<Student> studentDTOOptional = studentRepository
                .findstudentByemail(student.getemail());
        if (studentDTOOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }

        //DOB
        String[] yearMonthDay = studentDTO.getDateOfBirth().split("-");
        if (yearMonthDay.length != 3) {
            throw new RuntimeException("Date of birth is incorrect");
        }

        LocalDate dob = LocalDate.of(Integer.parseInt(yearMonthDay[0]), Integer.parseInt(yearMonthDay[1]), Integer.parseInt(yearMonthDay[2]));
        student.setDateOfBirth(dob);
        return studentRepository.save(student);
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }


}
