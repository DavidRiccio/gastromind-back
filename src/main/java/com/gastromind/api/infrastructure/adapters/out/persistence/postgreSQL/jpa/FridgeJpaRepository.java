package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastromind.api.domain.models.Fridge;

public interface FridgeJpaRepository extends JpaRepository<Fridge,String>{
    
}
