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

import com.gastromind.api.application.services.AllergenServiceImpl;
import com.gastromind.api.domain.models.Allergen;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/allergens")
@Tag(name = "Alérgeno", description = "Gestión del catálogo de alérgenos e intolerancias alimentarias.")
public class AllergenController {

    @Autowired
    AllergenServiceImpl allergenServiceImpl;

    @Operation(summary = "Obtener todos los alérgenos", description = "Devuelve una lista completa de todos los alérgenos registrados en el sistema.")
    @GetMapping
    @ApiStandardDoc
    public ResponseEntity<List<Allergen>> getAll() {
        return ResponseEntity.ok(allergenServiceImpl.findAll());
    }

    @Operation(summary = "Buscar alérgeno por ID", description = "Devuelve un único alérgeno basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<Allergen> getById(
            @Parameter(description = "ID del alérgeno a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(allergenServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nuevo alérgeno", description = "Registra un nuevo alérgeno en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<Allergen> create(@RequestBody Allergen allergen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(allergenServiceImpl.create(allergen));
    }

    @Operation(summary = "Actualizar alérgeno", description = "Modifica los datos de un alérgeno existente.")
    @PutMapping("/{id}")
    @ApiStandardDoc
    public ResponseEntity<Allergen> update(@PathVariable String id, @RequestBody Allergen allergen) {
        return ResponseEntity.ok(allergenServiceImpl.update(id, allergen));
    }

    @Operation(summary = "Eliminar alérgeno", description = "Borra físicamente un alérgeno de la base de datos.")
    @DeleteMapping("/{id}")
    @ApiStandardDoc
    public ResponseEntity<Void> delete(@PathVariable String id) {
        allergenServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}