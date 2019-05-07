package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApi {
    private EmployeeManager employeeManager;


    @Autowired
    public EmployeeApi(EmployeeManager employeeManager){
        this.employeeManager=employeeManager;
    }
    @GetMapping("/all")
    public Iterable<Employee> getAll(){
        return employeeManager.findAll();
    }
    @GetMapping
    public Optional<Employee> getById(@RequestParam Long index){
        return employeeManager.findById(index);
    }
}
