package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class RunAtStart {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public RunAtStart(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public  void runAtStart(){
        Employee employee = new Employee();
        employee.setName("Igor");
        employee.setSurName("Kabacinski");
        employee.setSalary(new BigDecimal("3000.00"));
        employeeRepository.save(employee);

        Iterable<Employee> igors = employeeRepository.findbyFirstName("Igor");
        Employee igor =igors.iterator().next();
       // System.out.println(igors.toString());

    }


}
