package com.gastromind.api.infrastructure.adapters.in.rest.mappers;

import com.gastromind.api.domain.models.UserFavorites;
import com.gastromind.api.infrastructure.adapters.in.rest.dtos.usualfavorites.UsualFavoritesRequest;
import com.gastromind.api.infrastructure.adapters.in.rest.dtos.usualfavorites.UsualFavoritesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserFavoritesRestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user_id.id", source = "user_id")
    @Mapping(target = "recipe_id.id", source = "recipe_id")
    UserFavorites toDomain(UsualFavoritesRequest request);

    @Mapping(target = "user_id", source = "user_id.id")
    @Mapping(target = "recipe_id", source = "recipe_id.id")
    UsualFavoritesResponse toResponse(UserFavorites domain);
}