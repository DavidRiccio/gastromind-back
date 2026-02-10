package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastromind.api.domain.models.UserFavorites;

public interface UserFavoritesJpaRepository extends JpaRepository<UserFavorites,String> {
    
}
