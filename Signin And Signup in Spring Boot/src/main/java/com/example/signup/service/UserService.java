package com.example.signup.service;

import com.example.signup.model.User;
import com.example.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean signup(User user) {
        if (userRepository.existsByUsernameOrEmail(user.getUsername(), user.getEmail())) {
            return false;
        }

        user.setPassword(encryptPassword(user.getPassword()));
        userRepository.save(user);

        return true;
    }

    public boolean signin(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, encryptPassword(password));

        return user != null;
    }

    private String encryptPassword(String password) {
        // Implement password encryption logic (e.g., using BCryptPasswordEncoder)
        // For simplicity, let's assume you have a method for this
        return password;
    }
}
