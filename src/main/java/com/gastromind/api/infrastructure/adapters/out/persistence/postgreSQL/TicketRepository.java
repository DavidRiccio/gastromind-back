package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gastromind.api.domain.models.Ticket;
import com.gastromind.api.domain.repositories.Ticketrepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.TicketJpaRepository;

public class TicketRepository implements Ticketrepository {

    @Autowired
    TicketJpaRepository ticketJpaRepository;

    @Override
    public Ticket save(Ticket ticket) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Ticket> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Ticket> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
}
