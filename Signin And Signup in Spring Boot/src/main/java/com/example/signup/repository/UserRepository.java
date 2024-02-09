package com.example.signup.repository;

import com.example.signup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsernameOrEmail(String username, String email);

    User findByUsername(String username);

    boolean existsByUsername(String username);

    User findByUsernameAndPassword(String username, String encryptPassword);
}
