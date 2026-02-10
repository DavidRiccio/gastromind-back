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

import com.gastromind.api.domain.models.Unit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/units")
@Tag(name = "Unidad", description = "Gestión del catálogo de unidades de medida para los ingredientes y productos.")
public class UnitController {

    @Operation(summary = "Obtener todas las unidades", description = "Devuelve una lista completa de todas las unidades de medida registradas.")
    @GetMapping
    public ResponseEntity<List<Unit>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar unidad por ID", description = "Devuelve una única unidad basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Unidad encontrada correctamente"),
        @ApiResponse(responseCode = "404", description = "Unidad no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Unit> getById(
            @Parameter(description = "ID de la unidad a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nueva unidad", description = "Registra una nueva unidad de medida en el sistema.")
    @PostMapping
    public ResponseEntity<Unit> create(@RequestBody Unit unit) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar unidad", description = "Modifica los datos de una unidad de medida existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Unit> update(@PathVariable Integer id, @RequestBody Unit unit) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar unidad", description = "Borra físicamente una unidad de medida de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}