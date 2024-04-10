package com.example.demo.service.serviceimpl;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.dto.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public  void deleteThestudent(Long id) {
        // to check if the student to be deleted exist
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("ID NOT Found!!");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "Student "+ id+ " does not exist"));
    }

    public Student addNewStudent(StudentDTO studentDTO) {
        //logic to convert dto to entity
        Student student = new Student();

        //to copy properties
        BeanUtils.copyProperties(studentDTO, student);
        logger.info("Student object = {}",student);
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
