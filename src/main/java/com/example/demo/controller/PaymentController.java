package com.example.demo.controller;

import com.example.demo.model.dto.ShowPaymentResponseDto;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{userId}")
    public ModelAndView showPayPage(@PathVariable Long userId, Model model) {
        ShowPaymentResponseDto paymentDetails = paymentService.getPaymentInfo(userId);
        ModelAndView modelAndView = new ModelAndView("paymentPage");
        modelAndView.addObject("paymentDetail", paymentDetails);
        return modelAndView;
    }

}