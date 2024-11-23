package com.example.demo.service;

import com.example.demo.model.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    void createReservation(Long userId, Long mealId);

    List<ReservationResponseDto> showAll(Long userId);

    void delete(Long reservationId);
}
