package com.example.demo.model.dto;

import java.util.List;

public class ShowPaymentResponseDto {
    private List<ReservationResponseDto> reservationDtos;
    private double totalPrice;
    private PersonDto personDto;

    public List<ReservationResponseDto> getReservationDtos() {
        return reservationDtos;
    }

    public void setReservationDtos(List<ReservationResponseDto> reservationDtos) {
        this.reservationDtos = reservationDtos;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }
}
