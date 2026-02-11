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

import com.gastromind.api.application.services.UnitServiceImpl;
import com.gastromind.api.domain.models.Unit;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/units")
@Tag(name = "Unidad", description = "Gestión del catálogo de unidades de medida para los ingredientes y productos.")
public class UnitController {

    @Autowired 
    UnitServiceImpl unitServiceImpl;

    @Operation(summary = "Obtener todas las unidades", description = "Devuelve una lista completa de todas las unidades de medida registradas.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<Unit>> getAll() {
        return ResponseEntity.ok(unitServiceImpl.findAll());
    }

    @Operation(summary = "Buscar unidad por ID", description = "Devuelve una única unidad basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<Unit> getById(
            @Parameter(description = "ID de la unidad a buscar", example = "1") 
            @PathVariable String id) {
        return ResponseEntity.ok(unitServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nueva unidad", description = "Registra una nueva unidad de medida en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<Unit> create(@RequestBody Unit unit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(unitServiceImpl.create(unit));
    }

    @Operation(summary = "Actualizar unidad", description = "Modifica los datos de una unidad de medida existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<Unit> update(@PathVariable String id, @RequestBody Unit unit) {
        return ResponseEntity.ok(unitServiceImpl.update(id, unit));
    }

    @Operation(summary = "Eliminar unidad", description = "Borra físicamente una unidad de medida de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        unitServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}