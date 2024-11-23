package com.example.demo.model.dto;

import com.example.demo.model.entity.FoodItem;

public class FoodItemDto {

    private long id;
    private String name;
    private Long price;
    private Long foodCategoryId;
    private Integer calories;
    private Integer fat;
    private Integer protein;
    private Long inventory;

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

    public static FoodItemDto map(FoodItem foodItem) {
        if (foodItem == null) {
            return null;
        }
        FoodItemDto dto = new FoodItemDto();
        dto.setId(foodItem.getId());
        dto.setName(foodItem.getName());
        dto.setPrice(foodItem.getPrice());
        dto.setInventory(foodItem.getInventory());
        dto.setCalories(foodItem.getCalories());
        dto.setProtein(foodItem.getProtein());
        dto.setFat(foodItem.getFat());
        return dto;
    }

}
