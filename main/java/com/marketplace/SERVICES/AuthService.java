package com.marketplace.service;

import com.marketplace.model.User;
import com.marketplace.repository.UserRepository;
import com.marketplace.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final ActivityLogService logService;
    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository repo,
                       PasswordEncoder encoder,
                       JwtUtil jwtUtil,
                       ActivityLogService logService) {

        this.repo = repo;
        this.encoder = encoder;
        this.jwtUtil = jwtUtil;
        this.logService = logService;
    }

    public User register(User user) {

        if (repo.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        user.setPassword(encoder.encode(user.getPassword()));
        User savedUser = repo.save(user);

        logService.log(savedUser.getId(),
                "User registered as " + savedUser.getRole());

        return savedUser;
    }

    public String login(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        logService.log(user.getId(), "User logged in");

        return jwtUtil.generateToken(user.getEmail());
    }
}