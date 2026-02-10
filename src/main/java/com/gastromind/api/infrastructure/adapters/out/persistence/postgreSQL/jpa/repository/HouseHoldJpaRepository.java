package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.HouseholdEntity;

import org.springframework.stereotype.Repository;

@Repository
public interface HouseHoldJpaRepository extends JpaRepository<HouseholdEntity, String> {
    
}
