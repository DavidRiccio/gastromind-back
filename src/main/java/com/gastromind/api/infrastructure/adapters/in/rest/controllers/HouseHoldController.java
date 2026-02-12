package com.gastromind.api.infrastructure.adapters.in.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gastromind.api.application.services.HouseHoldServiceImpl;
import com.gastromind.api.domain.models.HouseHold;
import com.gastromind.api.infrastructure.adapters.in.rest.dtos.household.HouseHoldRequest;
import com.gastromind.api.infrastructure.adapters.in.rest.dtos.household.HouseHoldResponse;
import com.gastromind.api.infrastructure.adapters.in.rest.mappers.HouseHoldRestMapper;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/households")
@Tag(name = "Unidad Familiar", description = "Gestión de las unidades familiares y la agrupación de usuarios.")
public class HouseHoldController {

    @Autowired
    private HouseHoldServiceImpl holdServiceImpl;

    @Autowired
    private HouseHoldRestMapper houseHoldMapper;

    @Operation(summary = "Obtener todas las unidades familiares", description = "Devuelve una lista completa de todas las unidades familiares registradas.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<HouseHoldResponse>> getAll() {
        List<HouseHold> households = holdServiceImpl.findAll();
        return ResponseEntity.ok(houseHoldMapper.toResponseList(households));
    }

    @Operation(summary = "Buscar unidad familiar por ID", description = "Devuelve una única unidad familiar basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<HouseHoldResponse> getById(
            @Parameter(description = "ID de la unidad familiar a buscar", example = "1") @PathVariable String id) {
        HouseHold houseHold = holdServiceImpl.findById(id);
        return ResponseEntity.ok(houseHoldMapper.toResponse(houseHold));
    }

    @Operation(summary = "Crear nueva unidad familiar", description = "Registra una nueva unidad familiar en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<HouseHoldResponse> create(@Valid @RequestBody HouseHoldRequest request) {
        HouseHold houseHoldDomain = houseHoldMapper.toDomain(request);
        HouseHold savedHouseHold = holdServiceImpl.create(houseHoldDomain);
        return ResponseEntity.status(HttpStatus.CREATED).body(houseHoldMapper.toResponse(savedHouseHold));
    }

    @Operation(summary = "Actualizar unidad familiar", description = "Modifica los datos de una unidad familiar existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<HouseHoldResponse> update(@PathVariable String id, @Valid @RequestBody HouseHoldRequest request) {
        HouseHold houseHoldDomain = houseHoldMapper.toDomain(request);
        HouseHold updatedHouseHold = holdServiceImpl.update(id, houseHoldDomain);
        return ResponseEntity.ok(houseHoldMapper.toResponse(updatedHouseHold));
    }

    @Operation(summary = "Eliminar unidad familiar", description = "Borra físicamente una unidad familiar de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        holdServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}