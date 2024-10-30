package org.alpha.relationonetoone.web;

import org.alpha.relationonetoone.entities.Profile;
import org.alpha.relationonetoone.entities.User;
import org.alpha.relationonetoone.repository.ProfileRepository;
import org.alpha.relationonetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    public String index(){
        return "profile";
    }
    @PostMapping("/")
    public String create(
            @RequestParam String biography,
            @RequestParam Long userId
            ){

        Profile profile = new Profile();
        profile.setBiography(biography);
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            profile.setUser(user.get());
        }else { throw new RuntimeException("User not found"); }

      Profile savedProfile=  profileRepository.save(profile);
      System.out.println(savedProfile.toString());
        return "profile";
    }
}
