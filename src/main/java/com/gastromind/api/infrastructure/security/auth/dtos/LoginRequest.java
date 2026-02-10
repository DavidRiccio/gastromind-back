package com.gastromind.api.infrastructure.security.auth.dtos;

public record LoginRequest(
        String username,
        String password
) {}
