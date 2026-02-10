package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import org.mapstruct.Mapper;
import com.gastromind.api.domain.models.Allergen;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.AllergenEntity;

@Mapper(componentModel = "spring")
public interface AllergenMapper {

    AllergenEntity toEntity(Allergen domain);

    Allergen toDomain(AllergenEntity entity);
}