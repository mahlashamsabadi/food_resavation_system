package com.example.demo.controller;


import com.example.demo.model.dto.FoodItemDto;
import com.example.demo.model.dto.MealDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.MealType;
import com.example.demo.service.FoodService;
import com.example.demo.service.MealService;
import com.example.demo.service.MealTypeService;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    MealService mealService;
    @Autowired
    FoodService foodService;
    @Autowired
    MealTypeService mealTypeService;

    @GetMapping
    public String showHomePage(Model model) {
        List<MealDto> meals = mealService.showDailyMeal();
        List<FoodItemDto> foodItems = foodService.findAllFoodItems();
        List<MealType> mealTypes = mealTypeService.findAll();
        model.addAttribute("meals", meals);
        model.addAttribute("foodItems", foodItems);
        model.addAttribute("mealTypes", mealTypes);
        return "home";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        UserDto userDto = userService.findUserByCredential(username, password);
        if (userDto != null) {
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("user", userDto);
            return "redirect:/home";
        }
        model.addAttribute("errorMessage", "Invalid username or password.");
        return "login";
    }

}
