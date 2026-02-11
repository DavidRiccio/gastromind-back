package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.gastromind.api.domain.models.UserFavorites;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.UserFavoritesEntity;

@Mapper(componentModel = "spring")
public interface UserFavoritesMapper {

    UserFavoritesEntity toEntity(UserFavorites domain);

    UserFavorites toDomain(UserFavoritesEntity entity);

    List<UserFavoritesEntity> toEntityList(List<UserFavorites> domainList);

    List<UserFavorites> toDomainList(List<UserFavoritesEntity> entityList);
}