package com.gastromind.api.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.gastromind.api.domain.models.Recipe;

public interface RecipeRepository {
    Recipe save(Recipe recipe);

    Optional<Recipe> findById(String id);

    void deleteById(String id);

    List<Recipe> findAll();
}
