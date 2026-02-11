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

import com.gastromind.api.application.services.UserFavoritesServiceImpl;
import com.gastromind.api.domain.models.UserFavorites;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/user-favorites")
@Tag(name = "Receta favorita", description = "Gestión del catálogo de recetas favoritas para usuarios y productos.")
public class UserFavoritesController {

    @Autowired
    UserFavoritesServiceImpl userFavoritesServiceImpl;

    @Operation(summary = "Obtener todas las recetas favoritas", description = "Devuelve una lista completa de todas las recetas favoritas registradas.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<UserFavorites>> getAll() {
        return ResponseEntity.ok(userFavoritesServiceImpl.findAll());
    }

    @Operation(summary = "Buscar receta favorita por ID", description = "Devuelve una única receta favorita basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<UserFavorites> getById(
            @Parameter(description = "ID de la receta favorita a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(userFavoritesServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nueva receta favorita", description = "Registra una nueva receta favorita en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<UserFavorites> create(@RequestBody UserFavorites userFavorites) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userFavoritesServiceImpl.create(userFavorites));
    }

    @Operation(summary = "Actualizar receta favorita", description = "Modifica los datos de una receta favorita existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<UserFavorites> update(@PathVariable String id, @RequestBody UserFavorites userFavorites) {
        return ResponseEntity.ok(userFavoritesServiceImpl.update(id, userFavorites));
    }

    @Operation(summary = "Eliminar receta favorita", description = "Borra físicamente una receta favorita de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userFavoritesServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}