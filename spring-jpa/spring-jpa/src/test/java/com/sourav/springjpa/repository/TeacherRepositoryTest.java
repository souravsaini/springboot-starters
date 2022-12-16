package com.sourav.springjpa.repository;

import com.sourav.springjpa.entity.Course;
import com.sourav.springjpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder().title("DBA").credit(6).build();
        Course courseDSA = Course.builder().title("DSA").credit(7).build();
        Teacher teacher = Teacher.builder().firstname("Kapil").lastname("Sharma").courses(List.of(courseDBA, courseDSA)).build();

        teacherRepository.save(teacher);
    }
}