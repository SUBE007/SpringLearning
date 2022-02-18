package com.dailycodebuffer.spring.data.jpa.tutorial.repository;


import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

      List<Student> findByFirstName(String firstName);
      List<Student> findByFirstNameContaining(String name);

     // List<Student> findByLastNameNotNull(String lastName);
      List<Student>  findByGuardianName(String name);
}
