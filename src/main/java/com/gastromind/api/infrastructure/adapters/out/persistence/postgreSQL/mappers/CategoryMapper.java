package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.gastromind.api.domain.models.Category;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.entities.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity toEntity(Category domain);

    Category toDomain(CategoryEntity entity);

    List<CategoryEntity> toEntityList(List<Category> domainList);

    List<Category> toDomainList(List<CategoryEntity> entityList);
}