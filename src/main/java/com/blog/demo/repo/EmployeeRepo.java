package com.blog.demo.repo;

import com.blog.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<List<Employee>> findEmployeesByUserId(Long userId);

    void deleteEmployeeByIdAndUserId(Long empId,Long userId);

    Optional<Employee> findEmployeesByUserIdAndId(Long userId, Long empId);
    Optional<List<Employee>> findEmployeesByUserIdAndJobTitle(Long userId, String jobTitle);
    Optional<List<Employee>> findEmployeesByUserIdAndName(Long userId, String name);
}
