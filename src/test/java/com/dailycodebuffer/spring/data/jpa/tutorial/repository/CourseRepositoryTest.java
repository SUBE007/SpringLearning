package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
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

   @Test
    public void findAllWithSorting(){

       Pageable sortByTitle=PageRequest.of(0,2,Sort.by("title"));

       Pageable sortByCreditDesc=PageRequest.of(0,2,
               Sort.by("credit").descending());

       Pageable sortByCreditAndTitle=PageRequest.of(0,2,
               Sort.by("title").descending()
                       .and
                               (Sort.by("credit").descending()));



       List<Course> courses1=courseRepository.findAll(sortByTitle).getContent();
       System.out.println("Courses: "+courses1);
       System.out.println("-----------------------------------");

       List<Course> courses2=courseRepository.findAll(sortByCreditDesc).getContent();
       System.out.println("Courses: "+courses2);
       System.out.println("-----------------------------------");

       List<Course> courses3=courseRepository.findAll(sortByCreditAndTitle).getContent();
       System.out.println("Courses: "+courses3);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageWithTenRecords=
                PageRequest.of(0,10);

        List<Course > courses=courseRepository
                     .findByTitleContaining("D",firstPageWithTenRecords).getContent();

        System.out.println("Course: "+courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacherTestingForManyTOManyMapping(){

        Teacher teacher=Teacher.builder()
                .firstName("John")
                .lastName("Shina")
                .build();

        Student student=Student.builder()
                .firstName("Sunny")
                .lastName("Li")
                .emailId("chunnumunnu@gmail.com")
                .build();

        Course course=Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}