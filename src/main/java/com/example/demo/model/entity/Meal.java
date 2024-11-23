package com.example.demo.model.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Meal {
    private long id;
    private String name;
    private MealType mealType;
    private Long inventory;
    private Date availableDate;
    private FoodItem foodItem;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meal_seq")
    @SequenceGenerator(name = "meal_seq", sequenceName = "meal_seq", allocationSize = 1)
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

    @ManyToOne
    @JoinColumn(name = "MEAL_TYPE_ID", nullable = false)
    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }

    @Column(name = "available_date")
    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @ManyToOne
    @JoinColumn(name = "FOOD_ITEM_ID", nullable = false)
    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

}
