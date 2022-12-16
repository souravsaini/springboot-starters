package com.sourav.springjpa.repository;

import com.sourav.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstname(String firstname);
    public List<Student> findByFirstnameContaining(String name);


}
