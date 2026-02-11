package com.gastromind.api.infrastructure.security.auth.dtos;

import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.enums.RoleType;

public record RegisterRequest(
        String username,
        String password,
        String email,
        RoleType role
) {}
