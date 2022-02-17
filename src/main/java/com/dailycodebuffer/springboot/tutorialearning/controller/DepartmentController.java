package com.dailycodebuffer.springboot.tutorialearning.controller;

import com.dailycodebuffer.springboot.tutorialearning.entity.Department;
import com.dailycodebuffer.springboot.tutorialearning.exceptionhandling.DepartmentNotFoundException;
import com.dailycodebuffer.springboot.tutorialearning.service.DepartmentService;
import com.dailycodebuffer.springboot.tutorialearning.service.DepartmentServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


//http://localhost:8082/
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);


    //POST-http://localhost:8082/departments
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
       // DepartmentService service=new DepartmentServiceImplementation();
        LOGGER.info("Inside saveDepartment of DepartmentController:");
        return departmentService.saveDepartment(department);

    }

    //GET-http://localhost:8082/departments
    @GetMapping("/departments")
    public List<Department> fetchDeparmentList(){
        return departmentService.fetchDepartmentList();
    }


    //GET-http://localhost:8082/departments/1
    @GetMapping("/departments/{id}")
    public Department departmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDeparmentList of DepartmentController:");
        return departmentService.fetchDepartmentById(departmentId);

    }


    //DELETE-http://localhost:8082/departments/1
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        LOGGER.info("Inside DeleteDepartment of DepartmentController:");
        return "Department deleted Successfully!!";

    }


    //PUT-http://localhost:8082/departments/2
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController:");
        return departmentService.updateDepartment(departmentId,department);
    }


    //GET-http://localhost:8082/departments/name/EE
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController:");
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
