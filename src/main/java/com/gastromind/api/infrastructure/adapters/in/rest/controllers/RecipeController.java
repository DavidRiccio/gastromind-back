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

import com.gastromind.api.application.services.RecipeServiceImpl;
import com.gastromind.api.domain.models.Recipe;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/recipes")
@Tag(name = "Receta", description = "Gestión del catálogo de recetas culinarias y sus pasos de preparación.")
public class RecipeController {

    @Autowired
    RecipeServiceImpl recipeServiceImpl;

    @Operation(summary = "Obtener todas las recetas", description = "Devuelve una lista completa de todas las recetas registradas.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<Recipe>> getAll() {
        return ResponseEntity.ok(recipeServiceImpl.findAll());
    }

    @Operation(summary = "Buscar receta por ID", description = "Devuelve una única receta basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(
            @Parameter(description = "ID de la receta a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(recipeServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nueva receta", description = "Registra una nueva receta en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<Recipe> create(@RequestBody Recipe recipe) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recipeServiceImpl.create(recipe));
    }

    @Operation(summary = "Actualizar receta", description = "Modifica los datos de una receta existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable String id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeServiceImpl.update(id, recipe));
    }

    @Operation(summary = "Eliminar receta", description = "Borra físicamente una receta de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        recipeServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}