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

import com.gastromind.api.domain.models.Fridge;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/fridges")
@Tag(name = "Nevera", description = "Gestión del inventario de la nevera y productos almacenados.")
public class FridgeController {

    @Operation(summary = "Obtener todas las neveras", description = "Devuelve una lista completa de todas las neveras registradas.")
    @GetMapping
    public ResponseEntity<List<Fridge>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar nevera por ID", description = "Devuelve una única nevera basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Nevera encontrada correctamente"),
        @ApiResponse(responseCode = "404", description = "Nevera no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Fridge> getById(
            @Parameter(description = "ID de la nevera a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nueva nevera", description = "Registra una nueva nevera en el sistema.")
    @PostMapping
    public ResponseEntity<Fridge> create(@RequestBody Fridge fridge) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar nevera", description = "Modifica los datos de una nevera existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Fridge> update(@PathVariable Integer id, @RequestBody Fridge fridge) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar nevera", description = "Borra físicamente una nevera de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}