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

import com.gastromind.api.domain.models.Product;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Producto", description = "Gestión del catálogo de productos disponibles en el sistema.")
public class ProductController {

    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista completa de todos los productos registrados.")
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar producto por ID", description = "Devuelve un único producto basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(
            @Parameter(description = "ID del producto a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nuevo producto", description = "Registra un nuevo producto en el sistema.")
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar producto", description = "Modifica los datos de un producto existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product product) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar producto", description = "Borra físicamente un producto de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}