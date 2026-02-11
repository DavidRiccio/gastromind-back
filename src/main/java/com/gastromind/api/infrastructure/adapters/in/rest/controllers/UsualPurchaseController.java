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

import com.gastromind.api.domain.models.UsualPurchase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/usual-purchase")
@Tag(name = "Producto más comprado", description = "Gestión de los registros de producto más comprado de un usuario.")
public class UsualPurchaseController {
                                                                                   
    @Operation(summary = "Obtener todos los registros de producto más comprado", description = "Devuelve una lista completa de todos los registros de producto más comprado.")
    @GetMapping
    public ResponseEntity<List<UsualPurchase>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar producto más comprado por ID", description = "Devuelve un único producto más comprado basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto más comprado encontrado correctamente"),
        @ApiResponse(responseCode = "404", description = "Producto más comprado no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UsualPurchase> getById(   
            @Parameter(description = "ID del producto más comprado a buscar", example = "1") 
            @PathVariable String id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nuevo producto más comprado", description = "Registra un nuevo producto más comprado en el sistema.")
    @PostMapping
    public ResponseEntity<UsualPurchase> create(@RequestBody UsualPurchase usualPurchase) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar producto más comprado", description = "Modifica los datos de un producto más comprado existente.")
    @PutMapping("/{id}")
    public ResponseEntity<UsualPurchase> update(@PathVariable String id, @RequestBody UsualPurchase usualPurchase) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar producto más comprado", description = "Borra físicamente un producto más comprado de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return ResponseEntity.noContent().build();
    }
}