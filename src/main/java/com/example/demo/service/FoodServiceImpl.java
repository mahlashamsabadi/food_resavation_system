package com.example.demo.service;

import com.example.demo.model.dto.FoodItemDto;
import com.example.demo.model.entity.FoodItem;
import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;

    @Override
    @Transactional(readOnly = true)
    public FoodItem findFoodById(Long id) {
        Optional<FoodItem> foodItem = foodRepository.findById(id);
        return foodItem.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItem> findFoodItemsByIds(List<Long> foodIds) {
        List<FoodItem> foodItems = new ArrayList<>();
        for (Long id : foodIds) {
            foodItems.add(findFoodById(id));
        }
        return foodItems;
    }

    @Override
    @Transactional(readOnly = true)
    public List<FoodItemDto> findAllFoodItems() {
        return foodRepository.findAll().stream().map(FoodItemDto::map).collect(Collectors.toList());
    }

}
