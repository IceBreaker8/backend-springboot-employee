package com.blog.demo.service;

import com.blog.demo.exceptions.UserNotFoundException;
import com.blog.demo.model.Profile;
import com.blog.demo.repo.ProfileRepo;
import com.blog.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProfileService {

    private final UserRepo userRepo;
    private final ProfileRepo profileRepo;

    @Autowired
    public ProfileService(UserRepo userRepo, ProfileRepo profileRepo) {
        this.userRepo = userRepo;
        this.profileRepo = profileRepo;
    }

    public List<Profile> getAllProfiles(){
        return profileRepo.findAll();
    }

    public Profile addProfileToUser(Long userId, Profile profile){
        userRepo.findById(userId).map(user -> {
            profile.setUser(user);
            return profileRepo.save(profile);

        }).orElseThrow(() -> new UserNotFoundException(""));
        return profile;
    }

    public void deleteProfile(Long userId){
        profileRepo.deleteProfileByUserId(userId);
    }

    public Profile updateUserProfile(Long userId,Profile profile){
        profileRepo.findProfileByUserId(userId).map(profile1 -> {
            profile1.setDescription(profile.getDescription());
            profile1.setPhone(profile.getPhone());
            return profileRepo.save(profile1);
        }).orElseThrow(() -> new UserNotFoundException(""));
        return profile;
    }



}
