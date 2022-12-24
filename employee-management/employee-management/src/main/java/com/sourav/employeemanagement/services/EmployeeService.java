package com.sourav.employeemanagement.services;

import com.sourav.employeemanagement.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
