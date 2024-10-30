package org.alpha.relationonetoone.web;

import org.alpha.relationonetoone.entities.User;
import org.alpha.relationonetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/create")
    public String createUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             @RequestParam String password,
                             Model model) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        model.addAttribute("user", user);
        userRepository.save(user);
        return "createUser"; // Return a view name
    }
    @GetMapping("/create")
    public  String getUser() {

        return "createUser";
    }

    @GetMapping("/")
    public  String index(Model model) {
        return "index";
    }
}
