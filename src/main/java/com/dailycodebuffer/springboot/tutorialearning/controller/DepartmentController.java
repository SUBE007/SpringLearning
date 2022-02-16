package com.dailycodebuffer.springboot.tutorialearning.controller;

import com.dailycodebuffer.springboot.tutorialearning.entity.Department;
import com.dailycodebuffer.springboot.tutorialearning.service.DepartmentService;
import com.dailycodebuffer.springboot.tutorialearning.service.DepartmentServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
       // DepartmentService service=new DepartmentServiceImplementation();
        LOGGER.info("Inside saveDepartment of DepartmentController:");
        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDeparmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department departmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside fetchDeparmentList of DepartmentController:");
        return departmentService.fetchDepartmentById(departmentId);

    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        LOGGER.info("Inside DeleteDepartment of DepartmentController:");
        return "Department deleted Successfully!!";

    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController:");
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController:");
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
