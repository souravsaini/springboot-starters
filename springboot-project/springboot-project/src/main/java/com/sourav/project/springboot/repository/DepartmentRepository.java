package com.sourav.project.springboot.repository;

import com.sourav.project.springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByName(String name);

    public Department findByNameIgnoreCase(String name);
}
