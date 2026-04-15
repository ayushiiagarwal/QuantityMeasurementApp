package com.app.user.controller;

import com.app.user.model.User;
import com.app.user.repository.UserRepository;
import com.app.user.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private UserRepository repo;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setProvider("LOCAL");
        user.setRole("USER");
        repo.save(user);
        return "User registered!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existing = repo.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(user.getPassword(), existing.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtUtil.generateToken(user.getEmail());
    }

    @GetMapping("/secure")
    public String secure() {
        return "This is secured!";
    }
}
