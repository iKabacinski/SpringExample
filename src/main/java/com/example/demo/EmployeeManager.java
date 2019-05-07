package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class EmployeeManager {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public Optional<Employee> findById(Long id){
    return employeeRepository.findById(id);
    }
    public Iterable<Employee> findAll(){
        return  employeeRepository.findAll();
    }
    public Employee save (Employee employee){
        return employeeRepository.save(employee);
    }
    public  void deleteById(Long id){
        employeeRepository.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Employee("Jan","Wow",new BigDecimal("4500"),LocalDate.of(1999,1,2)));
        save(new Employee("Jan","Wowo",new BigDecimal("4500.50"),LocalDate.of(2000,1,2)));

    }


   // @PostConstruct
   /* public void runAtStart() {
        Employee employee = new Employee();
        employee.setFirstName("Andrzej");
        employee.setLastName("Duda");
        employee.setSalary(new BigDecimal("0.00"));
        employeeRepository.save(employee);

    }*/


}
