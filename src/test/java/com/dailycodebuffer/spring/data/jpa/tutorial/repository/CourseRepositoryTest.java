package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println("Courses: "+courses);
    }

    @Test
    public void saveCourseWithTeacherObject(){
        Teacher teacher=Teacher.builder()
                .firstName("Shan")
                .lastName("Cobra")
                .build();

        Course course=Course.builder()
                .title("SNAKE")
                .credit(9)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public  void findAllPaginationWithTwoRecords(){

        Pageable firstPageWithThreeRecord= PageRequest.of(0,3);

        Pageable secondPageWithTwoRecord = PageRequest.of(1,2);

        List<Course> courses=courseRepository.findAll(secondPageWithTwoRecord)
                .getContent();

        long totalElement= courseRepository.findAll(secondPageWithTwoRecord)
                        .getTotalElements();

        long totalPages=courseRepository.findAll(secondPageWithTwoRecord)
                .getTotalPages();

        System.out.println("Courses: " +courses);
        System.out.println("Total Elements: " +totalElement);
        System.out.println("Total Pages: " +totalPages);

    }

    @Test
    public  void findAllPaginationWithThreeRecords(){

        Pageable firstPageWithThreeRecord= PageRequest.of(0,3);

        List<Course> courses=courseRepository.findAll(firstPageWithThreeRecord)
                .getContent();

        long totalElement= courseRepository.findAll(firstPageWithThreeRecord)
                .getTotalElements();

        long totalPages=courseRepository.findAll(firstPageWithThreeRecord)
                .getTotalPages();

        System.out.println("Courses: " +courses);
        System.out.println("Total Elements: " +totalElement);
        System.out.println("Total Pages: " +totalPages);

    }


}