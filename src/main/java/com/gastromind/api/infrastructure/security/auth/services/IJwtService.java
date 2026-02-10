package com.gastromind.api.infrastructure.security.auth.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {
    String generateToken(String username);
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isValid(String token);
}
