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

import com.gastromind.api.domain.models.Ticket;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/tickets")
@Tag(name = "Ticket", description = "Gestión de tickets de compra y registros de transacciones.")
public class TicketController {

    @Operation(summary = "Obtener todos los tickets", description = "Devuelve una lista completa de todos los tickets registrados.")
    @GetMapping
    public ResponseEntity<List<Ticket>> getAll() {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Buscar ticket por ID", description = "Devuelve un único ticket basándose en su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ticket encontrado correctamente"),
        @ApiResponse(responseCode = "404", description = "Ticket no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(
            @Parameter(description = "ID del ticket a buscar", example = "1") 
            @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Crear nuevo ticket", description = "Registra un nuevo ticket en el sistema.")
    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "Actualizar ticket", description = "Modifica los datos de un ticket existente.")
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> update(@PathVariable Integer id, @RequestBody Ticket ticket) {
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Eliminar ticket", description = "Borra físicamente un ticket de la base de datos.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }
}