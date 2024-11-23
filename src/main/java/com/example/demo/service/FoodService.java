package com.example.demo.service;

import com.example.demo.model.dto.FoodItemDto;
import com.example.demo.model.entity.FoodItem;

import java.util.List;

public interface FoodService {
    FoodItem findFoodById(Long id);

    List<FoodItem> findFoodItemsByIds(List<Long> foodIds);
    List<FoodItemDto> findAllFoodItems();
}
