package com.blog.demo.repo;

import com.blog.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

}
