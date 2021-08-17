package com.blog.demo.repo;


import com.blog.demo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProfileRepo extends JpaRepository<Profile, Long> {

    void deleteProfileByUserId(Long userId);

    Optional<Profile> findProfileByUserId(Long userId);
}
