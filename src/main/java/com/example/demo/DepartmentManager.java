package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentManager {

    private final DepartmentRepository departmentRepository;

    @Autowired

    public DepartmentManager(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }


}

