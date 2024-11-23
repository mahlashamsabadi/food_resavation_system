package com.example.demo.controller;

import com.example.demo.model.dto.MealDto;
import com.example.demo.service.MealService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;


@Controller
@RequestMapping("/meal")
public class MealController {
    @Autowired
    MealService mealService;

    @PostMapping("/add")
    @ResponseBody
    public String add(@ModelAttribute MealDto mealDto) {
        try {
            mealService.addMeal(mealDto);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/home";
    }

    @PostMapping("/edit")
    @ResponseBody
    public String edit(@ModelAttribute MealDto mealDto) {
        try {
            mealService.editMeal(mealDto);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/home";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody Map<String, Object> request) {
        Long mealId = Long.valueOf(String.valueOf(request.get("id")));
        mealService.deleteMeal(mealId);
        return "redirect:/home";
    }
}
