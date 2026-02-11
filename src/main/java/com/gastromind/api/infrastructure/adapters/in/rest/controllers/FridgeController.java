package com.gastromind.api.infrastructure.adapters.in.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gastromind.api.application.services.FridgeServiceImpl;
import com.gastromind.api.domain.models.Fridge;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/fridges")
@Tag(name = "Nevera", description = "Gestión del inventario de la nevera y productos almacenados.")
public class FridgeController {

    @Autowired
    FridgeServiceImpl fridgeServiceImpl;

    @Operation(summary = "Obtener todas las neveras", description = "Devuelve una lista completa de todas las neveras registradas.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<Fridge>> getAll() {
        return ResponseEntity.ok(fridgeServiceImpl.findAll());
    }

    @Operation(summary = "Buscar nevera por ID", description = "Devuelve una única nevera basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<Fridge> getById(
            @Parameter(description = "ID de la nevera a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(fridgeServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nueva nevera", description = "Registra una nueva nevera en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<Fridge> create(@RequestBody Fridge fridge) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fridgeServiceImpl.create(fridge));
    }

    @Operation(summary = "Actualizar nevera", description = "Modifica los datos de una nevera existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<Fridge> update(@PathVariable String id, @RequestBody Fridge fridge) {
        return ResponseEntity.ok(fridgeServiceImpl.update(id, fridge));
    }

    @Operation(summary = "Eliminar nevera", description = "Borra físicamente una nevera de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        fridgeServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}