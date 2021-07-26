package com.blog.demo.repo;

import com.blog.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional<List<Employee>> findEmployeesByJobTitle(String jobTitle);
    Optional<Employee> findEmployeeById(Long id);
    Optional<List<Employee>> findEmployeesByNameContaining(String substring);
}
