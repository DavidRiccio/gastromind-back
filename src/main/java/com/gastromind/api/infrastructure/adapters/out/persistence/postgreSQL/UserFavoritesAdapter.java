package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gastromind.api.domain.models.UserFavorites;
import com.gastromind.api.domain.ports.out.UserFavoritesRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.UserFavoritesEntity;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.UserFavoritesJpaRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers.UserFavoritesMapper;
@Component
public class UserFavoritesAdapter implements UserFavoritesRepository {

    @Autowired
    UserFavoritesJpaRepository userFavoritesJpaRepository;

    @Autowired
    UserFavoritesMapper userFavoritesMapper;

    @Override
    public UserFavorites save(UserFavorites userFavorites) {
         UserFavoritesEntity entity = userFavoritesMapper.toEntity(userFavorites);
        return userFavoritesMapper.toDomain(userFavoritesJpaRepository.save(entity));
    }

    @Override
    public Optional<UserFavorites> findById(String id) {
        return userFavoritesJpaRepository.findById(id).map(userFavoritesMapper::toDomain);
    }

    @Override
    public void deleteById(String id) {
        userFavoritesJpaRepository.deleteById(id);
    }

    @Override
    public List<UserFavorites> findAll() {
        List<UserFavoritesEntity> userFavoritesEntities = userFavoritesJpaRepository.findAll();
        return userFavoritesMapper.toDomainList(userFavoritesEntities);
    }

   }