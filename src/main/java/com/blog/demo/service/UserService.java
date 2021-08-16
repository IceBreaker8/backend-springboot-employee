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
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;
    private final EmployeeRepo employeeRepo;

    @Autowired
    public UserService(UserRepo userRepo, EmployeeRepo employeeRepo) {
        this.userRepo = userRepo;
        this.employeeRepo = employeeRepo;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public User updateUser(Long id,User user){
        return userRepo.findById(id).map(user1 -> {
            user1.setEmail(user.getEmail());
            user1.setUsername(user.getUsername());
            user1.setAge(user.getAge());
            return userRepo.save(user1);
        }).orElseThrow(() -> new UserNotFoundException(""));
    }
    public User findUser(Long id){
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException(""));
    }

}
