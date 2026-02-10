package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastromind.api.domain.models.Product;

public interface ProductJpaRepository extends JpaRepository<Product, String>{
    
}
