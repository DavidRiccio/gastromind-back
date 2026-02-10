package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.UsualPurchaseEntity;

import org.springframework.stereotype.Repository;

@Repository
public interface UsualPurchaseJpaRepository extends JpaRepository<UsualPurchaseEntity,String> {
    
}
