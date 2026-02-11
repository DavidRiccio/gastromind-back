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

import com.gastromind.api.application.services.CategoryServiceImpl;
import com.gastromind.api.domain.models.Category;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/categories")
@Tag(name = "Categoría", description = "Gestión del catálogo de categorías para la clasificación de productos y recetas.")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    @Operation(summary = "Obtener todas las categorías", description = "Devuelve una lista completa de todas las categorías registradas.")
    @GetMapping
    @ApiStandardDoc
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryServiceImpl.findAll());
    }

    @Operation(summary = "Buscar categoría por ID", description = "Devuelve una única categoría basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(
            @Parameter(description = "ID de la categoría a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(categoryServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nueva categoría", description = "Registra una nueva categoría en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryServiceImpl.create(category));
    }

    @Operation(summary = "Actualizar categoría", description = "Modifica los datos de una categoría existente.")
    @PutMapping("/{id}")
    @ApiStandardDoc
    public ResponseEntity<Category> update(@PathVariable String id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryServiceImpl.update(id,category));
    }

    @Operation(summary = "Eliminar categoría", description = "Borra físicamente una categoría de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        categoryServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}