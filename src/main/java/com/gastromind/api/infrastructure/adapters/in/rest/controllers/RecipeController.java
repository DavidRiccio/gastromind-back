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

import com.gastromind.api.domain.models.Recipe;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/recipes")
@Tag(name = "Receta", description = "Gestión del catálogo de recetas culinarias y sus pasos de preparación.")
public class RecipeController {

    @Operation(summary = "Obtener todas las recetas", description = "Devuelve una lista completa de todas las recetas registradas.")
    @GetMapping
    public ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar receta por ID", description = "Devuelve una única receta basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Receta encontrada correctamente"),
        @ApiResponse(responseCode = "404", description = "Receta no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(
            @Parameter(description = "ID de la receta a buscar", example = "1") 
            @PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nueva receta", description = "Registra una nueva receta en el sistema.")
    @PostMapping
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar receta", description = "Modifica los datos de una receta existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable String id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar receta", description = "Borra físicamente una receta de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}