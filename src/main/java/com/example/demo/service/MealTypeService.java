package com.example.demo.service;

import com.example.demo.model.entity.MealType;

import java.util.List;

public interface MealTypeService {

    MealType findMealTypeById(Long id);

    List<MealType> findAll();
}
