package com.example.demo.repository;

import com.example.demo.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    @Query(value = "select t.* from meal t where trunc(t.AVAILABLE_DATE)=trunc(current_date)", nativeQuery = true)
    List<Meal> findDailyMeals();
}
