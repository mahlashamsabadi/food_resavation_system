package com.example.demo.service;

import com.example.demo.model.entity.MealType;
import com.example.demo.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MealTypeServiceImpl implements MealTypeService {

    @Autowired
    MealTypeRepository mealTypeRepository;

    @Override
    @Transactional(readOnly = true)
    public MealType findMealTypeById(Long id) {
        Optional<MealType> mealType = mealTypeRepository.findById(id);
        return mealType.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MealType> findAll() {
        return mealTypeRepository.findAll();
    }

}
