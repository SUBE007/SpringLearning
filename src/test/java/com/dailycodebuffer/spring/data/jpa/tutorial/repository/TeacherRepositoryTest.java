package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDSA=Course.builder()
                .title("DSA")
                .credit(5)
                .build();

        Course courseDLD=Course.builder()
                .title("DLD")
                .credit(6)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("ABID")
                .lastName("KHAN")
                .courses(courseDSA)
                .courses(courseDLD)
                .build();

    teacherRepository.save(teacher);
    }


}