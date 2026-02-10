package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gastromind.api.domain.models.User;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.UserEntity;

@Mapper(componentModel = "spring", uses = {HouseholdMapper.class})
public interface UserMapper {

    @Mapping(source = "houseHold_id", target = "household")
    UserEntity toEntity(User user);

    @Mapping(source = "household", target = "houseHold_id")
    User toDomain(UserEntity entity);
}