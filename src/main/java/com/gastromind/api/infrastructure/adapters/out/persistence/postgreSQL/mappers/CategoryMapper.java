package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import org.mapstruct.Mapper;
import com.gastromind.api.domain.models.Category;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity toEntity(Category domain);

    Category toDomain(CategoryEntity entity);
}