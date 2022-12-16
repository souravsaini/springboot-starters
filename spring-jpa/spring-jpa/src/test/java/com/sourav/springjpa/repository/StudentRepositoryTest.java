package com.sourav.springjpa.repository;

import com.sourav.springjpa.entity.Guardian;
import com.sourav.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                            .email("sourav@gmail.com")
                            .firstname("Sourav")
                            .lastname("Saini")
//                            .guardianName("Lakshya")
//                            .guardianEmail("lakshya@gmail.com")
//                            .guardianMobile("9875768456")
                            .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Lakshya")
                .email("lakshya@gmail.com")
                .mobile("9875768456")
                .build();

        Student student = Student.builder()
                .email("souravs@gmail.com")
                .firstname("Sourav")
                .lastname("Saini")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    @Test
    public void listStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void getStudentsByFirstname() {
        List<Student> students = studentRepository.findByFirstname("Sourav");
        System.out.println(students);
    }

    @Test
    public void getStudentsByFirstnameContaining() {
        List<Student> students = studentRepository.findByFirstnameContaining("Sou");
        System.out.println(students);
    }
}