package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import org.mapstruct.Mapper;
import com.gastromind.api.domain.models.Unit;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.UnitEntity;

@Mapper(componentModel = "spring")
public interface UnitMapper {

    UnitEntity toEntity(Unit domain);

    Unit toDomain(UnitEntity entity);
}