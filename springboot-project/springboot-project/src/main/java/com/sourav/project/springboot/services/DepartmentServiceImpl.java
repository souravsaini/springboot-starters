package com.sourav.project.springboot.services;

import com.sourav.project.springboot.entity.Department;
import com.sourav.project.springboot.error.DepartmentNotFoundException;
import com.sourav.project.springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not present");
        }
        return department.get();

    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department existingDepartment = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getName()) && !"".equalsIgnoreCase(department.getName())) {
            existingDepartment.setName(department.getName());
        }
        if(Objects.nonNull(department.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
            existingDepartment.setAddress(department.getAddress());
        }
        if(Objects.nonNull(department.getCode()) && !"".equalsIgnoreCase(department.getCode())) {
            existingDepartment.setCode(department.getCode());
        }

        return departmentRepository.save(existingDepartment);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByNameIgnoreCase(name);
    }
}
