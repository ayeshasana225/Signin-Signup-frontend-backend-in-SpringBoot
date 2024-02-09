package com.example.signup.controller;

import com.example.signup.model.User;
import com.example.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        if (userService.signup(user)) {
            model.addAttribute("signupSuccess", true);
            model.addAttribute("username", user.getUsername());
            return "welcome";
        } else {
            model.addAttribute("error", "Username or Email already exists");
            return "signup";
        }
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }

    @PostMapping("/signin")
    public String signin(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.signin(username, password)) {
            model.addAttribute("signinSuccess", true);
            model.addAttribute("username", username);
            return "welcome";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "signin";
        }
    }
}
