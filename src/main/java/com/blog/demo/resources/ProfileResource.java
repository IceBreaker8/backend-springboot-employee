package com.blog.demo.resources;

import com.blog.demo.model.Profile;
import com.blog.demo.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileResource {

    private final ProfileService profileService;

    public ProfileResource(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }

    @PostMapping("/add/users/{userId}")
    public ResponseEntity<Profile> addProfileToUser(@PathVariable(name = "userId") Long userId,
                                                    @RequestBody Profile profile) {
        Profile profile1 = profileService.addProfileToUser(userId, profile);
        return new ResponseEntity<>(profile1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/users/{userId}")
    public ResponseEntity<?> removeUserProfile(@PathVariable("userId") Long userId) {
        profileService.deleteProfile(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/users/{userId}")
    public ResponseEntity<Profile> updateUserProfile(@PathVariable("userId") Long userId,
                                                     @RequestBody Profile profile) {
        Profile profile1 = profileService.updateUserProfile(userId, profile);
        return new ResponseEntity<>(profile1, HttpStatus.OK);
    }
}
