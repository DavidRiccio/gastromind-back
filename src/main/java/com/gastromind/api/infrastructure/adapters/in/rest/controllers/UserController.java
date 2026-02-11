package com.gastromind.api.infrastructure.adapters.in.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gastromind.api.application.services.UserServiceImpl;
import com.gastromind.api.domain.models.User;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "Usuario", description = "Gestión de los perfiles de usuario en el sistema.")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Operation(summary = "Obtener todos los usuarios", description = "Devuelve una lista completa de todos los usuarios registrados.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userServiceImpl.findAll());
    }

    @Operation(summary = "Buscar usuario por ID", description = "Devuelve un único usuario basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(
            @Parameter(description = "ID del usuario a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(userServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.create(user));
    }

    @Operation(summary = "Actualizar usuario", description = "Modifica los datos de un usuario existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody User user) {
        return ResponseEntity.ok(userServiceImpl.update(id, user));
    }

    @Operation(summary = "Eliminar usuario", description = "Borra físicamente un usuario de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}