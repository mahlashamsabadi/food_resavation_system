package com.example.demo.model.dto;


import com.example.demo.model.entity.Reservation;

import java.text.SimpleDateFormat;

public class ReservationResponseDto {
    private long id;
    private String mealName;
    private String mealType;
    private String status;
    private String reservationDate;
    private int quantity;
    private Long totalPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public static ReservationResponseDto map(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        ReservationResponseDto dto = new ReservationResponseDto();
        dto.setId(reservation.getId());
        dto.setMealName(reservation.getMeal().getName());
        dto.setStatus(reservation.getStatus());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dto.setReservationDate(format.format(reservation.getReservationDate()));
        dto.setQuantity(reservation.getQuantity());
        dto.setTotalPrice(reservation.getTotalPrice());
        dto.setMealType(reservation.getMeal().getMealType().getName());
        return dto;
    }
}
