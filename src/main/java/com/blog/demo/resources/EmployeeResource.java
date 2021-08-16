package com.blog.demo.resources;

import com.blog.demo.model.Employee;
import com.blog.demo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //user
    @GetMapping("/get/users/{userId}/all")
    public ResponseEntity<List<Employee>> getAllEmployees(@PathVariable("userId") Long userId) {
        List<Employee> employees = employeeService.findAllEmployees(userId);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/post/users/{userId}")
    public ResponseEntity<?> addEmployee(@PathVariable Long userId,
                                         @RequestBody Employee employee) {
        employeeService.addEmployeeToUser(userId, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/users/{userId}/employees/{empId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("userId") Long userId,
                                            @PathVariable("empId") Long empId) {
        employeeService.deleteEmployee(userId, empId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/users/{userId}/employees/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("userId") Long userId,
                                                   @PathVariable("empId") Long empId,
                                                   @RequestBody Employee employee) {
        employeeService.updateEmployee(userId, empId, employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/users/{userId}/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("userId") Long userId,
                                                    @PathVariable("empId") Long empId) {
        Employee employee = employeeService.findEmployeesById(userId, empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("/jobs/users/{userId}/employees/{jobTitle}")
    public ResponseEntity<List<Employee>>
    getEmployeesByJobTitle(@PathVariable("jobTitle") String jobTitle,
                           @PathVariable("userId") Long userId) {
        List<Employee> employees = employeeService.findEmployeesByJobTitle(userId, jobTitle);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/search/users/{userId}/employees/{name}")
    public ResponseEntity<List<Employee>>
    getEmployeesByNameContaining(@PathVariable("userId") Long userId,
                                 @PathVariable("name") String name) {
        List<Employee> employees = employeeService.findEmployeesByNameContaining(userId, name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


}