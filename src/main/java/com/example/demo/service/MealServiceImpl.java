package com.example.demo.service;

import com.example.demo.model.dto.MealDto;
import com.example.demo.model.entity.FoodItem;
import com.example.demo.model.entity.Meal;
import com.example.demo.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    MealTypeService mealTypeService;
    @Autowired
    FoodService foodService;

    @Override
    @Transactional(readOnly = true)
    public List<MealDto> showDailyMeal() {
        List<Meal> dailyMeals = mealRepository.findDailyMeals();
        return dailyMeals.stream().map(MealDto::map).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addMeal(MealDto mealDto) throws ParseException {
        Meal meal = new Meal();
        meal.setName(mealDto.getName());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        meal.setAvailableDate(dateFormat.parse(mealDto.getAvailableDate()));
        meal.setInventory(mealDto.getInventory());
        meal.setMealType(mealTypeService.findMealTypeById(mealDto.getMealTypeId()));
        FoodItem foodItem = foodService.findFoodById(mealDto.getFoodItemId());
        meal.setFoodItem(foodItem);
        mealRepository.save(meal);
    }

    @Override
    @Transactional
    public void editMeal(MealDto mealDto) throws ParseException {
        Optional<Meal> mealById = mealRepository.findById(mealDto.getId());
        if (mealById.isPresent()) {
            Meal meal = mealById.get();
            meal.setMealType(mealTypeService.findMealTypeById(mealDto.getMealTypeId()));
            meal.setName(mealDto.getName());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            meal.setAvailableDate(dateFormat.parse(mealDto.getAvailableDate()));
            meal.setInventory(mealDto.getInventory());
            FoodItem foodItem = foodService.findFoodById(mealDto.getFoodItemId());
            meal.setFoodItem(foodItem);
            mealRepository.save(meal);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Meal findMealById(Long id) {
        Optional<Meal> meal = mealRepository.findById(id);
        return meal.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteMeal(Long id) {
        Optional<Meal> meal = mealRepository.findById(id);
        meal.ifPresent(value -> mealRepository.delete(value));
    }

    @Override
    public Long calculatePrice(Meal meal) {
        return meal.getFoodItem().getPrice();
    }

    @Override
    @Transactional
    public void save(Meal meal) {
        mealRepository.save(meal);
    }

}
