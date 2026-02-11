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

import com.gastromind.api.application.services.UsualPurchaseServiceImpl;
import com.gastromind.api.domain.models.UsualPurchase;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/usual-purchase")
@Tag(name = "Producto más comprado", description = "Gestión de los registros de producto más comprado de un usuario.")
public class UsualPurchaseController {

    @Autowired
    UsualPurchaseServiceImpl usualPurchaseServiceImpl;

    @Operation(summary = "Obtener todos los registros de producto más comprado", description = "Devuelve una lista completa de todos los registros de producto más comprado.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<UsualPurchase>> getAll() {
        return ResponseEntity.ok(usualPurchaseServiceImpl.findAll());
    }

    @Operation(summary = "Buscar producto más comprado por ID", description = "Devuelve un único producto más comprado basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<UsualPurchase> getById(
            @Parameter(description = "ID del producto más comprado a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(usualPurchaseServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nuevo producto más comprado", description = "Registra un nuevo producto más comprado en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<UsualPurchase> create(@RequestBody UsualPurchase usualPurchase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usualPurchaseServiceImpl.create(usualPurchase));
    }

    @Operation(summary = "Actualizar producto más comprado", description = "Modifica los datos de un producto más comprado existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<UsualPurchase> update(@PathVariable String id, @RequestBody UsualPurchase usualPurchase) {
        return ResponseEntity.ok(usualPurchaseServiceImpl.update(id, usualPurchase));
    }

    @Operation(summary = "Eliminar producto más comprado", description = "Borra físicamente un producto más comprado de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        usualPurchaseServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}