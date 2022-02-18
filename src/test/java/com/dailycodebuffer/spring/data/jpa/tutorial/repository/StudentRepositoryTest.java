package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("sube@gmail.com")
                .firstName("Subedar")
                .lastName("Chaurasiya")
//                .name("Dube")
//                .email("dube@gmil.com")
//                .mobile("0070070077")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian= Guardian.builder()
                .name("Dube")
                .email("dube@gmil.com")
                .mobile("0070070077")
                .build();

        Student student=Student.builder()
                .firstName("Subedar")
                .emailId("sube@gmail.com")
                .lastName("Chaurasiya")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=
                studentRepository.findAll();

        System.out.println("StudentList: "+studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("Subedar");

        System.out.println("Student"+studentList);

    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("Su");

        System.out.println("Student"+studentList);

    }

    @Test
    public void printStudentBasedOnGuardianName(){
        //List<Student> studentList=studentRepository.findByGuardianName("Dube");

        List<Student> students =studentRepository.findByGuardianName("Dube");
        System.out.println("Student"+students);

    }

    @Test
    public void printStudentNameBasedFirstNameAndLastName(){


        List<Student> students =studentRepository.findByFirstNameAndLastName("Subedar","Chaurasiya");
        System.out.println("Student"+students);

    }

    @Test
    public void printGetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("sube@gmail.com");

        System.out.println("Student"+student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentFirstNameByEmailAddress("sube@gmail.com");

        System.out.println("firstName "+firstName);
    }

}