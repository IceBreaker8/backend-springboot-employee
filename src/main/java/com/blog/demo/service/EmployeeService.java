package com.blog.demo.service;

import com.blog.demo.exceptions.UserNotFoundException;
import com.blog.demo.model.Employee;
import com.blog.demo.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public void updateEmployee(Long id,Employee employee) {
        Employee employee1 = employeeRepo.getById(id);
        employee1.setEmail(employee.getEmail());
        employee1.setName(employee.getName());
        employee1.setJobTitle(employee.getJobTitle());
        employee1.setPhone(employee.getPhone());
        employee1.setImageUrl(employee.getImageUrl());
    }


    public List<Employee> findAllEmployeesByJobTitle(String title) {
        return employeeRepo.findEmployeesByJobTitle(title).
                orElseThrow(() -> new UserNotFoundException("Can't find employees"));
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).
                orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

    public List<Employee> findEmployeesByNameContaining(String name) {
        return employeeRepo.findEmployeesByNameContaining(name).
                orElseThrow(() -> new UserNotFoundException("Can't find employees"));
    }
}
