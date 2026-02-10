package com.gastromind.api.infrastructure.security.auth.services.impl;

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
        /**
        return userRepository.findByUsername(username)
                .map(user -> {
                    boolean matches = passwordEncoder.matches(password, user.getPassword());
                    return matches;
                })
                .orElseGet(false);
         */
        return true; // TODO: reemplazar por la parte comentada
    }

    @Override
    public void register(RegisterRequest request) {
        /** TODO: implementar la parte comentada
        if (userRepository.findByUsername(request.username()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        UserEntity user = new UserEntity();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));

        String formattedRole = request.role().startsWith("ROLE_") ?
                request.role() : "ROLE_" + request.role().toUpperCase();
        user.setRole(formattedRole);

        userRepository.save(user);
         */
    }
}

