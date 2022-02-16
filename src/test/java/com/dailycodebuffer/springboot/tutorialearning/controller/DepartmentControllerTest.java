package com.dailycodebuffer.springboot.tutorialearning.controller;

import com.dailycodebuffer.springboot.tutorialearning.entity.Department;
import com.dailycodebuffer.springboot.tutorialearning.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
          department=Department.builder()
                  .departmentAddress("HYDERABAD")
                  .departmentCode("IT-86")
                  .departmentName("IT")
                  .departmentId(1l)
                  .build();



    }

    @Test
    void saveDepartment() throws Exception {

       Department inputDepartment=Department.builder()
                .departmentAddress("HYDERABAD")
                .departmentCode("IT-86")
                .departmentName("IT")
                .build();

       Mockito.when(departmentService.saveDepartment(inputDepartment))
               .thenReturn(department);

       mockMvc.perform(post("/departments") //added on Demand Static method
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\n" +
                       "     \"departmentName\":\"IT\",\n" +
                       "    \"departmentAddress\":\"HYDERABAD\",\n" +
                       "    \"departmentCode\":\"IT-69\"\n" +
                       "\n" +
                       "}"))
               .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() {
    }
}