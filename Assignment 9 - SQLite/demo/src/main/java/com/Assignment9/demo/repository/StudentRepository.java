package com.Assignment9.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Assignment9.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
