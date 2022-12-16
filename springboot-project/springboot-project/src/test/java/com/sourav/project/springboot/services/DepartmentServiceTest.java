package com.sourav.project.springboot.services;

import com.sourav.project.springboot.entity.Department;
import com.sourav.project.springboot.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().name("IT").address("Bangalore").code("CSE-01").departmentId(5).build();

        Mockito.when(departmentRepository.findByNameIgnoreCase("IT")).thenReturn(department);
    }

    @Test
    public void validDepartmentFound() {
        String name = "IT";
        Department found = departmentService.getDepartmentByName(name);

        assertEquals(name, found.getName());
    }
}