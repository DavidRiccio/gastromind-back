package com.gastromind.api.infrastructure.security.auth.dtos;

public record RegisterRequest(
        String username,
        String password,
        String role
) {}
