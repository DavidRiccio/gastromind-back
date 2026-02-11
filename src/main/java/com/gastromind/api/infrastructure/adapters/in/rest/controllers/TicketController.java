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

import com.gastromind.api.application.services.TicketServiceImpl;
import com.gastromind.api.domain.models.Ticket;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiPostDoc;
import com.gastromind.api.infrastructure.adapters.in.rest.doc.ApiStandardDoc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/tickets")
@Tag(name = "Ticket", description = "Gestión de tickets de compra y registros de transacciones.")
public class TicketController {

    @Autowired 
    TicketServiceImpl ticketServiceImpl;

    @Operation(summary = "Obtener todos los tickets", description = "Devuelve una lista completa de todos los tickets registrados.")
    @ApiStandardDoc
    @GetMapping
    public ResponseEntity<List<Ticket>> getAll() {
        return ResponseEntity.ok(ticketServiceImpl.findAll());
    }

    @Operation(summary = "Buscar ticket por ID", description = "Devuelve un único ticket basándose en su identificador único.")
    @ApiStandardDoc
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(
            @Parameter(description = "ID del ticket a buscar", example = "1") 
            @PathVariable String id) {
        return ResponseEntity.ok(ticketServiceImpl.findById(id));
    }

    @Operation(summary = "Crear nuevo ticket", description = "Registra un nuevo ticket en el sistema.")
    @ApiPostDoc
    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketServiceImpl.create(ticket));
    }

    @Operation(summary = "Actualizar ticket", description = "Modifica los datos de un ticket existente.")
    @ApiStandardDoc
    @PutMapping("/{id}")
    public ResponseEntity<Ticket> update(@PathVariable String id, @RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketServiceImpl.update(id, ticket));
    }

    @Operation(summary = "Eliminar ticket", description = "Borra físicamente un ticket de la base de datos.")
    @ApiStandardDoc
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        ticketServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }
}