package com.sourav.project.springboot.repository;

import com.sourav.project.springboot.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().name("ME").code("ME-01").address("Delhi").build();

        entityManager.persist(department);
    }

    @Test
    public void findByIdTest() {
        Department department = departmentRepository.findById(5L).get();
        assertEquals(department.getName(), "ME");
    }


}