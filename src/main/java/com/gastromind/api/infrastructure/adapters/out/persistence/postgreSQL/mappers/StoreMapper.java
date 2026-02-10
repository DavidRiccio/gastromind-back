package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import org.mapstruct.Mapper;
import com.gastromind.api.domain.models.Store;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.StoreEntity;

@Mapper(componentModel = "spring")
public interface StoreMapper {

    StoreEntity toEntity(Store domain);

    Store toDomain(StoreEntity entity);
}