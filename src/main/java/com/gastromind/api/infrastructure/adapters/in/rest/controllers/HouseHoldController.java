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

import com.gastromind.api.application.services.HouseHoldServiceImpl;
import com.gastromind.api.domain.models.HouseHold;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/households")
@Tag(name = "Unidad Familiar", description = "Gestión de las unidades familiares y la agrupación de usuarios.")
public class HouseHoldController {

    @Autowired
    HouseHoldServiceImpl holdServiceImpl;

    @Operation(summary = "Obtener todas las unidades familiares", description = "Devuelve una lista completa de todas las unidades familiares registradas.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<HouseHold>> getAll() {
        return ResponseEntity.ok(holdServiceImpl.findAll());
    }

    @Operation(summary = "Buscar unidad familiar por ID", description = "Devuelve una única unidad familiar basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<HouseHold> getById(
            @Parameter(description = "ID de la unidad familiar a buscar", example = "1") @PathVariable String id) {
        return ResponseEntity.ok(holdServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nueva unidad familiar", description = "Registra una nueva unidad familiar en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<HouseHold> create(@RequestBody HouseHold houseHold) {
        return ResponseEntity.status(HttpStatus.CREATED).body(holdServiceImpl.create(houseHold));
    }

    @Operation(summary = "Actualizar unidad familiar", description = "Modifica los datos de una unidad familiar existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<HouseHold> update(@PathVariable String id, @RequestBody HouseHold houseHold) {
        return ResponseEntity.ok(holdServiceImpl.update(id, houseHold));
    }

    @Operation(summary = "Eliminar unidad familiar", description = "Borra físicamente una unidad familiar de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        holdServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}