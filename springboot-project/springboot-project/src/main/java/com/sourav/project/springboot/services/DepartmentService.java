package com.sourav.project.springboot.services;

import com.sourav.project.springboot.entity.Department;
import com.sourav.project.springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department getDepartmentByName(String name);
}
