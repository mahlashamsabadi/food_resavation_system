package com.example.demo.service;

import com.example.demo.model.dto.PersonDto;
import com.example.demo.model.dto.ReservationResponseDto;
import com.example.demo.model.dto.ShowPaymentResponseDto;
import com.example.demo.model.entity.Person;
import com.example.demo.model.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    ReservationService reservationService;
    @Autowired
    PersonService personService;

    @Override
    @Transactional(readOnly = true)
    public ShowPaymentResponseDto getPaymentInfo(Long userId) {
        List<ReservationResponseDto> responseDtos = new ArrayList<>();
        double totalPrice = 0;
        List<Reservation> reservations = reservationService.findByUserIdAndStatus(userId, "pending");
        if (reservations != null && !reservations.isEmpty()) {
            responseDtos = reservations.stream().map(ReservationResponseDto::map).collect(Collectors.toList());
            totalPrice = reservations.stream()
                    .mapToDouble(Reservation::getTotalPrice)
                    .sum();
        }
        Person person = personService.findPersonByUserId(userId);
        PersonDto personDto = PersonDto.map(person);
        ShowPaymentResponseDto showPaymentResponseDto = new ShowPaymentResponseDto();
        showPaymentResponseDto.setReservationDtos(responseDtos);
        showPaymentResponseDto.setTotalPrice(totalPrice);
        showPaymentResponseDto.setPersonDto(personDto);
        return showPaymentResponseDto;
    }

}
