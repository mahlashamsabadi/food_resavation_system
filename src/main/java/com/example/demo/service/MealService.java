package com.example.demo.service;

import com.example.demo.model.dto.MealDto;
import com.example.demo.model.entity.Meal;

import java.text.ParseException;
import java.util.List;

public interface MealService {
    List<MealDto> showDailyMeal();

    void addMeal(MealDto mealDto) throws ParseException;

    void editMeal(MealDto mealDto) throws ParseException;

    Meal findMealById(Long id);

    void deleteMeal(Long id);

    Long calculatePrice(Meal meal);

    void save(Meal meal);
}
