package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.UserEntity;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String>{
    Optional<UserEntity> findByName(String name);
}
