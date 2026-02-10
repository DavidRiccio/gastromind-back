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

import com.gastromind.api.domain.models.HouseHold;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/households")
@Tag(name = "Unidad Familiar", description = "Gestión de las unidades familiares y la agrupación de usuarios.")
public class HouseHoldController {

    @Operation(summary = "Obtener todas las unidades familiares", description = "Devuelve una lista completa de todas las unidades familiares registradas.")
    @GetMapping
    public ResponseEntity<List<HouseHold>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar unidad familiar por ID", description = "Devuelve una única unidad familiar basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Unidad familiar encontrada correctamente"),
        @ApiResponse(responseCode = "404", description = "Unidad familiar no encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<HouseHold> getById(
            @Parameter(description = "ID de la unidad familiar a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nueva unidad familiar", description = "Registra una nueva unidad familiar en el sistema.")
    @PostMapping
    public ResponseEntity<HouseHold> create(@RequestBody HouseHold houseHold) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar unidad familiar", description = "Modifica los datos de una unidad familiar existente.")
    @PutMapping("/{id}")
    public ResponseEntity<HouseHold> update(@PathVariable Integer id, @RequestBody HouseHold houseHold) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar unidad familiar", description = "Borra físicamente una unidad familiar de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}