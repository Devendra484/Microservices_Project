package com.springboot.controller;

import com.springboot.model.Department;
import com.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/savedep")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public  Department getDepartment(@PathVariable Long id){
        return departmentService.getDepartment(id);
    }
}
