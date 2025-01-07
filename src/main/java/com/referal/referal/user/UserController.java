package com.referal.referal.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword())
                .map(loggedInUser -> ResponseEntity.ok("Login successful!"))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User newUser = userService.register(user);
            return ResponseEntity.ok("User registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering user: " + e.getMessage());
        }
    }
}
