package com.sourav.project.springboot.controllers;

import com.sourav.project.springboot.entity.Department;
import com.sourav.project.springboot.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder().address("Delhi").code("ME-01").name("ME").departmentId(1).build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department input = Department.builder().address("Delhi").code("ME-01").name("ME").build();

        Mockito.when(departmentService.saveDepartment(input)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "    \"name\": \"Computer Science\",\n" +
                "    \"address\": \"Block 26, CS Department\",\n" +
                "    \"code\": \"CSE01\"\n" +
                "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}