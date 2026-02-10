package com.gastromind.api.infrastructure.adapters.in.rest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gastromind.api.domain.models.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Usuario", description = "Gestión de los perfiles de usuario en el sistema.")
public class UserController {

    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista completa de todos los usuarios registrados.")
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar usuario por ID", description = "Devuelve un único usuario basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Usuario encontrado correctamente"),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(
            @Parameter(description = "ID del usuario a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en el sistema.")
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar usuario", description = "Modifica los datos de un usuario existente.")
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar usuario", description = "Borra físicamente un usuario de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}