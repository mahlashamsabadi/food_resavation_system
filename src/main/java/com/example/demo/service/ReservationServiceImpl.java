package com.example.demo.service;

import com.example.demo.model.dto.ReservationResponseDto;
import com.example.demo.model.entity.AppUser;
import com.example.demo.model.entity.Meal;
import com.example.demo.model.entity.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    UserService userService;
    @Autowired
    MealService mealService;

    @Override
    @Transactional
    public void createReservation(Long userId, Long mealId) {
        Reservation reservation = new Reservation();
        AppUser user = userService.findUserById(userId);
        Meal meal = mealService.findMealById(mealId);
        reservation.setUser(user);
        reservation.setMeal(meal);
        reservation.setReservationDate(new Date());
        reservation.setCreationDate(new Date());
        reservation.setModificationDate(new Date());
        reservation.setQuantity(1);
        reservation.setStatus("pending");
        reservation.setTotalPrice(mealService.calculatePrice(meal));
        reservationRepository.save(reservation);
        meal.setInventory(meal.getInventory() - 1);
        mealService.save(meal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservationResponseDto> showAll(Long userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        if (reservations != null && !reservations.isEmpty()) {
            return reservations.stream().map(ReservationResponseDto::map).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public void delete(Long reservationId) {
        Optional<Reservation> reservationById = reservationRepository.findById(reservationId);
        if (reservationById.isPresent()) {
            Reservation reservation = reservationById.get();
            reservation.setDisableDate(new Date());
            reservationRepository.save(reservation);
            Meal meal = reservation.getMeal();
            meal.setInventory(meal.getInventory() + 1);
        }
    }

    @Override
    public List<Reservation> findByUserIdAndStatus(Long userId, String status) {
        return reservationRepository.findByUserIdAndStatus(userId, status);
    }

}
