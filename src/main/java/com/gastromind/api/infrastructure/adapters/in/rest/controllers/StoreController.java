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

import com.gastromind.api.domain.models.Store;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/stores")
@Tag(name = "Tienda", description = "Gestión del catálogo de tiendas y establecimientos comerciales.")
public class StoreController {

    @Operation(summary = "Obtener todas las tiendas", description = "Devuelve una lista completa de todas las tiendas registradas.")
    @GetMapping
    public ResponseEntity<List<Store>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar tienda por ID", description = "Devuelve una única tienda basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Tienda encontrada correctamente"),
        @ApiResponse(responseCode = "404", description = "Tienda no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Store> getById(
            @Parameter(description = "ID de la tienda a buscar", example = "1") 
            @PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nueva tienda", description = "Registra una nueva tienda en el sistema.")
    @PostMapping
    public ResponseEntity<Store> create(@RequestBody Store store) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar tienda", description = "Modifica los datos de una tienda existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Store> update(@PathVariable String id, @RequestBody Store store) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar tienda", description = "Borra físicamente una tienda de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}