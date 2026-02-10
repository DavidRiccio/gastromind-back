package com.gastromind.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.gastromind.api.domain.models.Ticket;

public interface Ticketrepository {
    Ticket save(Ticket ticket);

    Optional<Ticket> findById(String id);

    void deleteById(String id);

    List<Ticket> findAll();
}
