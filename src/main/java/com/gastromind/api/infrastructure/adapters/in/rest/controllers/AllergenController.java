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

import com.gastromind.api.domain.models.Allergen;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/allergens")
@Tag(name = "Alérgenos", description = "Gestión del catálogo de alérgenos para usuarios y productos")
public class AllergenController {

    @Operation(summary = "Obtener todos los alérgenos", description = "Devuelve una lista completa de todos los alérgenos registrados.")
    @GetMapping
    public ResponseEntity<List<Allergen>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar alérgeno por ID", description = "Devuelve un único alérgeno basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alérgeno encontrado correctamente"),
        @ApiResponse(responseCode = "404", description = "Alérgeno no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Allergen> getById(
            @Parameter(description = "ID del alérgeno a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nuevo alérgeno", description = "Registra un nuevo alérgeno en el sistema.")
    @PostMapping
    public ResponseEntity<Allergen> create(@RequestBody Allergen allergen) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar alérgeno", description = "Modifica los datos de un alérgeno existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Allergen> update(@PathVariable Integer id, @RequestBody Allergen allergen) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar alérgeno", description = "Borra físicamente un alérgeno de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}