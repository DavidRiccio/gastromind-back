package com.gastromind.api.infrastructure.security.auth.controllers;

import com.gastromind.api.infrastructure.security.auth.dtos.LoginRequest;
import com.gastromind.api.infrastructure.security.auth.dtos.RegisterRequest;
import com.gastromind.api.infrastructure.security.auth.dtos.TokenResponse;
import com.gastromind.api.infrastructure.security.auth.services.IAuthService;
import com.gastromind.api.infrastructure.security.auth.services.IJwtService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    private final IAuthService authService;
    private final IJwtService jwtService;

    public AuthController(IAuthService authService, IJwtService jwtService) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    @Operation(summary = "Login with an existing user")
    public TokenResponse login(@RequestBody LoginRequest req) {
        if (!authService.validateCredentials(req.username(), req.password())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }
        try {
            return new TokenResponse(jwtService.generateToken(req.username()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error generando token: " + e.getMessage());
        }
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return ResponseEntity.ok("User registered successfully");
    }
}
