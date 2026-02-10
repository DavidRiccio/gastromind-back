package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.gastromind.api.domain.models.HouseHold;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.HouseholdEntity;

@Mapper(componentModel = "spring")
public interface HouseholdMapper {

    @Mapping(source = "members", target = "members_count")
    HouseholdEntity toEntity(HouseHold domain);

    @Mapping(source = "members_count", target = "members")
    HouseHold toDomain(HouseholdEntity entity);

    List<HouseholdEntity> toEntityList(List<HouseHold> domainList);
    List<HouseHold> toDomainList(List<HouseholdEntity> entityList);
}