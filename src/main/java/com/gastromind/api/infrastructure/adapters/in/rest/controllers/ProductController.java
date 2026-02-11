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

import com.gastromind.api.application.services.ProductServiceImpl;
import com.gastromind.api.domain.models.Product;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Producto", description = "Gestión del catálogo de productos disponibles en el sistema.")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @Operation(summary = "Obtener todos los productos", description = "Devuelve una lista completa de todos los productos registrados.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productServiceImpl.findAll());
    }

    @Operation(summary = "Buscar producto por ID", description = "Devuelve un único producto basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(
            @Parameter(description = "ID del producto a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(productServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nuevo producto", description = "Registra un nuevo producto en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productServiceImpl.create(product));
    }

    @Operation(summary = "Actualizar producto", description = "Modifica los datos de un producto existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product product) {
        return ResponseEntity.ok(productServiceImpl.update(id, product));
    }

    @Operation(summary = "Eliminar producto", description = "Borra físicamente un producto de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        productServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}