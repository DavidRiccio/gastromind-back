package com.gastromind.api.infrastructure.security.auth.services.impl;

import com.gastromind.api.domain.models.enums.Role;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.UserEntity;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.UserJpaRepository;
import com.gastromind.api.infrastructure.security.auth.dtos.RegisterRequest;
import com.gastromind.api.infrastructure.security.auth.services.IAuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    private final UserJpaRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserJpaRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean validateCredentials(String username, String password) {
        return userRepository.findByName(username)
                .map(user -> passwordEncoder.matches(password, user.getPassword()))
                .orElse(false);
    }

    @Override
    public void register(RegisterRequest request) {
        if (userRepository.findByName(request.username()).isPresent()) {
            throw new RuntimeException("Ya existe un usuario con esas credenciales");
        }

        UserEntity user = new UserEntity();
        user.setName(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setEmail(request.email());
        user.setRole(request.role());

        userRepository.save(user);
    }
}

