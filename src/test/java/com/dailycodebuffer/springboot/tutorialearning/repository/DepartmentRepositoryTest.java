package com.dailycodebuffer.springboot.tutorialearning.repository;

import com.dailycodebuffer.springboot.tutorialearning.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department=
                Department.builder()
                        .departmentName("Instrumentation_Engg")
                        .departmentCode("IC-69")
                        .departmentAddress("KOTA")
                        .build();

        entityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department=departmentRepository.findById(1l).get();

        assertEquals(department.getDepartmentName(),"Instrumentation_Engg");

    }
}