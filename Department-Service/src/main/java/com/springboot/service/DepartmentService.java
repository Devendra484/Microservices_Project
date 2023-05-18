package com.springboot.service;

import com.springboot.Repository.DepartmentRepository;
import com.springboot.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        Department department1= departmentRepository.save(department);
        System.out.println(department1);
        return department1;
    }

    public Department getDepartment(Long id) {
        return  departmentRepository.findById(id).orElseThrow(()->new NoSuchElementException("No Department found with Id :"+id));
    }
}
