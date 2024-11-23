package com.example.demo.model.dto;

import com.example.demo.model.entity.Meal;

import java.text.SimpleDateFormat;

public class MealDto {
    private long id;
    private String name;
    private Integer price;
    private Long mealTypeId;
    private String mealTypeName;
    private Long inventory;
    private String availableDate;
    private Long foodItemId;
    private String foodItemName;


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getMealTypeId() {
        return mealTypeId;
    }

    public void setMealTypeId(Long mealTypeId) {
        this.mealTypeId = mealTypeId;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public String getMealTypeName() {
        return mealTypeName;
    }

    public void setMealTypeName(String mealTypeName) {
        this.mealTypeName = mealTypeName;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public static MealDto map(Meal meal) {
        if (meal == null) {
            return null;
        }
        MealDto dto = new MealDto();
        dto.setId(meal.getId());
        dto.setName(meal.getName());
        dto.setMealTypeId(meal.getMealType() != null ? meal.getMealType().getId() : null);
        dto.setMealTypeName(meal.getMealType() != null ? meal.getMealType().getName() : null);
        dto.setInventory(meal.getInventory());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dto.setAvailableDate(format.format(meal.getAvailableDate()));
        dto.setFoodItemId(meal.getFoodItem().getId());
        dto.setFoodItemName(meal.getFoodItem().getName());
        return dto;
    }

}
