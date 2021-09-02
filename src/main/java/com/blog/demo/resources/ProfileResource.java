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

    @GetMapping("/find/users/{email}")
    public ResponseEntity<Profile> getProfile(@PathVariable("email")String email){
        Profile profile = profileService.getProfileByUserEmail(email);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        List<Profile> profiles = profileService.getAllProfiles();
        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }



    @PostMapping("/add/users/{email}")
    public ResponseEntity<Profile> addProfileToUser(@PathVariable(name = "email") String email,
                                                    @RequestBody Profile profile) {
        Profile profile1 = profileService.addProfileToUser(email, profile);
        return new ResponseEntity<>(profile1, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/users/{email}")
    public ResponseEntity<?> removeUserProfile(@PathVariable("email") String email) {
        profileService.deleteProfile(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/users/{email}")
    public ResponseEntity<Profile> updateUserProfile(@PathVariable("email") String email,
                                                     @RequestBody Profile profile) {
        Profile profile1 = profileService.updateUserProfile(email, profile);
        return new ResponseEntity<>(profile1, HttpStatus.OK);
    }
}
