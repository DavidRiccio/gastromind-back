package com.gastromind.infrastructure.adapters.out.persistence.postgreSQL.entities;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal quantityRequired;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private RecipeEntity recipe;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitEntity unit;

    public RecipeIngredientEntity() {
    }

    public RecipeIngredientEntity(Integer id) {
        this.id = id;
    }

    public RecipeIngredientEntity(Integer id, BigDecimal quantityRequired, RecipeEntity recipe, ProductEntity product,
            UnitEntity unit) {
        this.id = id;
        this.quantityRequired = quantityRequired;
        this.recipe = recipe;
        this.product = product;
        this.unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantityRequired() {
        return quantityRequired;
    }

    public void setQuantityRequired(BigDecimal quantityRequired) {
        this.quantityRequired = quantityRequired;
    }

    public RecipeEntity getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeEntity recipe) {
        this.recipe = recipe;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
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
        RecipeIngredientEntity other = (RecipeIngredientEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
