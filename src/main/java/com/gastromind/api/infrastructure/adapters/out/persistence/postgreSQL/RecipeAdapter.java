package com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.gastromind.api.domain.models.Recipe;
import com.gastromind.api.domain.repositories.RecipeRepository;
import com.gastromind.api.infrastructure.adapters.out.persistence.postgreSQL.jpa.repository.RecipeJpaRepository;

public class RecipeAdapter implements RecipeRepository {

    @Autowired
    RecipeJpaRepository recipeJpaRepository;

    @Override
    public Recipe save(Recipe recipe) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Recipe> findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Recipe> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
