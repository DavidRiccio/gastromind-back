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

import com.gastromind.api.domain.models.UserFavorites;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/user-favorites")
@Tag(name = "Receta favorita", description = "Gestión del catálogo de recetas favoritas para usuarios y productos.")
public class UserFavoritesController {

    @Operation(summary = "Obtener todas las recetas favoritas", description = "Devuelve una lista completa de todas las recetas favoritas registradas.")
    @GetMapping
    public ResponseEntity<List<UserFavorites>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar receta favorita por ID", description = "Devuelve una única receta favorita basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Receta favorita encontrada correctamente"),
        @ApiResponse(responseCode = "404", description = "Receta favorita no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserFavorites> getById(
            @Parameter(description = "ID de la receta favorita a buscar", example = "1") 
            @PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nueva receta favorita", description = "Registra una nueva receta favorita en el sistema.")
    @PostMapping
    public ResponseEntity<UserFavorites> create(@RequestBody UserFavorites userFavorites) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar receta favorita", description = "Modifica los datos de una receta favorita existente.")
    @PutMapping("/{id}")
    public ResponseEntity<UserFavorites> update(@PathVariable String id, @RequestBody UserFavorites userFavorites) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar receta favorita", description = "Borra físicamente una receta favorita de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}