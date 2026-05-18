package com.marketplace.CONTROLLERS;

import com.marketplace.DOT.LoginRequest;
import com.marketplace.model.User;
import com.marketplace.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return service.login(
                request.getEmail(),
                request.getPassword()
        );
    }
}