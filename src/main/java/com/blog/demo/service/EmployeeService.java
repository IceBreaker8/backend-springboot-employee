package com.blog.demo.service;

import com.blog.demo.exceptions.UserNotFoundException;
import com.blog.demo.model.Employee;
import com.blog.demo.model.User;
import com.blog.demo.repo.EmployeeRepo;
import com.blog.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final UserRepo userRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo, UserRepo userRepo) {
        this.employeeRepo = employeeRepo;
        this.userRepo = userRepo;
    }

    public void addEmployeeToUser(Long userId, Employee employee) {
        userRepo.findById(userId).map(user -> {
            employee.setUser(user);
            return employeeRepo.save(employee);

        });
    }

    public void deleteEmployee(Long userId, Long id) {
        employeeRepo.deleteEmployeeByIdAndUserId(id,userId);
    }

    public List<Employee> findAllEmployees(Long userId) {
        return employeeRepo.findEmployeesByUserId(userId).
            orElseThrow(() -> new UserNotFoundException("Can't find employees"));
    }

    public void updateEmployee(Long userId, Long empId, Employee employee) {
        if(userRepo.existsById(userId)) {
            employeeRepo.findById(empId).map(employee1 -> {
                employee1.setEmail(employee.getEmail());
                employee1.setName(employee.getName());
                employee1.setJobTitle(employee.getJobTitle());
                employee1.setPhone(employee.getPhone());
                employee1.setImageUrl(employee.getImageUrl());
                return employeeRepo.save(employee1);
            });
        }


    }
    public Employee findEmployeesById(Long userId,Long empId) {
        return employeeRepo.findEmployeesByUserIdAndId(userId,empId)
                .orElseThrow(() -> new UserNotFoundException(""));
    }

    public List<Employee> findEmployeesByJobTitle(Long userId, String jobTitle) {
        return employeeRepo.findEmployeesByUserIdAndJobTitle(userId,jobTitle)
                .orElseThrow(() -> new UserNotFoundException(""));
    }
//////////////////////////////////////////////////////////////////////////////////////////



    public List<Employee> findEmployeesByNameContaining(Long userId, String name) {
        return employeeRepo.findEmployeesByUserIdAndName(userId,name).
                orElseThrow(() -> new UserNotFoundException("Can't find employees"));
    }


}
