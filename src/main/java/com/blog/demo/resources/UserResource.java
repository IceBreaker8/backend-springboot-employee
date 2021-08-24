package com.blog.demo.resources;


import com.blog.demo.model.Employee;
import com.blog.demo.model.User;
import com.blog.demo.repo.EmployeeRepo;
import com.blog.demo.repo.UserRepo;
import com.blog.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        User user1 = userService.updateUser(userId,user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long userId){
        User user1 = userService.findUser(userId);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
   @GetMapping("/search/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email){
        User user1 = userService.searchUserByEmail(email);
        return new ResponseEntity<>(user1,HttpStatus.OK);
   }

}
