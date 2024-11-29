package com.example.demo.service;

import com.example.demo.model.dto.ReservationResponseDto;
import com.example.demo.model.entity.Reservation;

import java.util.List;

public interface ReservationService {
    void createReservation(Long userId, Long mealId);

    List<ReservationResponseDto> showAll(Long userId);

    void delete(Long reservationId);

    List<Reservation> findByUserIdAndStatus(Long userId, String status);
}
