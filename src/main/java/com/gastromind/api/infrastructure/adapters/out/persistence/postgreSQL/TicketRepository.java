package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gastromind.api.domain.models.Ticket;
import com.gastromind.api.domain.repositories.Ticketrepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.TicketEntity;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.TicketJpaRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers.TicketMapper;
@Component
public class TicketRepository implements Ticketrepository {

    @Autowired
    TicketJpaRepository ticketJpaRepository;

    @Autowired
    TicketMapper ticketMapper;

    @Override
    public Ticket save(Ticket ticket) {
        TicketEntity entity = ticketMapper.toEntity(ticket);
        return ticketMapper.toDomain(ticketJpaRepository.save(entity));
    }

    @Override
    public Optional<Ticket> findById(String id) {
        return ticketJpaRepository.findById(id).map(ticketMapper::toDomain);
    }

    @Override
    public void deleteById(String id) {
       ticketJpaRepository.deleteById(id);
    }

    @Override
    public List<Ticket> findAll() {
        List<TicketEntity> ticketEntities = ticketJpaRepository.findAll();
        return ticketMapper.toDomainList(ticketEntities);
    }
    
}
