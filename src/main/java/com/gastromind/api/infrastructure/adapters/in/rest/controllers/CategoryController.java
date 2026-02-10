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

import com.gastromind.api.domain.models.Category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Categorías", description = "Gestión del catálogo de categorías para usuarios y productos")
public class CategoryController {

    @Operation(summary = "Obtener todos los categorías", description = "Devuelve una lista completa de todos los categorías registrados.")
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar categoría por ID", description = "Devuelve un único categoría basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "categoría encontrado correctamente"),
        @ApiResponse(responseCode = "404", description = "categoría no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(
            @Parameter(description = "ID del categoría a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nueva categoría", description = "Registra un nueva categoría en el sistema.")
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar categoría", description = "Modifica los datos de un categoría existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Integer id, @RequestBody Category category) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar categoría", description = "Borra físicamente un categoría de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}
