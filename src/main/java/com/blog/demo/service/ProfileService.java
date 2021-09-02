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

    public Profile getProfileByUserEmail(String email){
        return profileRepo.findProfileByUserEmail(email).
                orElseThrow(() -> new UserNotFoundException(""));
    }
    public List<Profile> getAllProfiles(){
        return profileRepo.findAll();
    }
    public Profile addProfileToUser(String email, Profile profile){
        userRepo.findUserByEmail(email).map(user -> {
            profile.setUser(user);
            return profileRepo.save(profile);

        }).orElseThrow(() -> new UserNotFoundException(""));
        return profile;
    }

    public void deleteProfile(String email){
        profileRepo.deleteProfileByUserEmail(email);
    }

    public Profile updateUserProfile(String email,Profile profile){
        profileRepo.findProfileByUserEmail(email).map(profile1 -> {
            profile1.setPosition(profile.getPosition());
            profile1.setAge(profile.getAge());
            profile1.setCompany(profile.getCompany());
            profile1.setPhone(profile.getPhone());
            return profileRepo.save(profile1);
        }).orElseThrow(() -> new UserNotFoundException(""));
        return profile;
    }



}
