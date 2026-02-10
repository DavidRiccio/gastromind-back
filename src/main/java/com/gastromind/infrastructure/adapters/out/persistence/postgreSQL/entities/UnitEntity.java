package com.gastromind.infrastructure.adapters.out.persistence.postgreSQL.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "unit")
public class UnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "unit")
    private List<RecipeIngredientEntity> recipeIngredients;

    public UnitEntity() {
    }

    public UnitEntity(Integer id) {
        this.id = id;
    }

    public UnitEntity(Integer id, String name, List<RecipeIngredientEntity> recipeIngredients) {
        this.id = id;
        this.name = name;
        this.recipeIngredients = recipeIngredients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredientEntity> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientEntity> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnitEntity other = (UnitEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
