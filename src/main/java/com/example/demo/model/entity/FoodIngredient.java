package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FOOD_INGREDIENT", schema = "FR")
public class FoodIngredient {
    private long id;
    private long foodId;
    private long ingredientId;
    private Long quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_ingredient_seq")
    @SequenceGenerator(name = "food_ingredient_seq", sequenceName = "food_ingredient_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FOOD_ID")
    public long getFoodId() {
        return foodId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    @Basic
    @Column(name = "INGREDIENT_ID")
    public long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
