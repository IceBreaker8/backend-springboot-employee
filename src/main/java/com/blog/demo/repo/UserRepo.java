package com.blog.demo.repo;

import com.blog.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {



}
