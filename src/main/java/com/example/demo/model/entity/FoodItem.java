package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "FOOD_ITEM", schema = "FR")
public class FoodItem {
    private long id;
    private String name;
    private Long price;
    private Long foodCategoryId;
    private Integer calories;
    private Integer fat;
    private Integer protein;
    private Long inventory;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "food_item_seq")
    @SequenceGenerator(name = "food_item_seq", sequenceName = "food_item_seq", allocationSize = 1)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "FOOD_CATEGORY_ID")
    public Long getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(Long foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

}
