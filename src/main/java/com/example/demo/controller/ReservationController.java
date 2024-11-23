package com.example.demo.controller;

import com.example.demo.model.dto.ReservationRequestDto;
import com.example.demo.model.dto.ReservationResponseDto;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/showHistory/{userId}")
    public ModelAndView showReservation(@PathVariable  Long userId) {
        List<ReservationResponseDto> reservations = reservationService.showAll(userId);
        ModelAndView modelAndView = new ModelAndView("reservationHistory");
        modelAndView.addObject("reservations", reservations);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createReservation(@RequestBody ReservationRequestDto request) {
        reservationService.createReservation(request.getUserId(), request.getMealId());
        return "Reservation created successfully";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestBody Map<String, Object> request) {
        Long reservationId = Long.valueOf(String.valueOf(request.get("id")));
        reservationService.delete(reservationId);
        return "redirect:/reservationHistory";
    }

}
