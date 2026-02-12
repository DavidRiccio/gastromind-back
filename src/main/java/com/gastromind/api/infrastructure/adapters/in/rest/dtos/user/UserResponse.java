package com.gastromind.api.infrastructure.adapters.in.rest.dtos.user;

import com.gastromind.api.domain.models.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Información pública del usuario")
public record UserResponse(

        @Schema(example = "usr-00123")
        String id,

        @Schema(example = "Juan Pérez")
        String name,

        @Schema(example = "juan@gastromind.com")
        String email,

        @Schema(example = "house-789-xyz")
        String houseHold_id,

        @Schema(example = "ROLE_MEMBER")
        Role role
) {}