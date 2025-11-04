package com.college.StudentData.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.college.StudentData.nodel.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
