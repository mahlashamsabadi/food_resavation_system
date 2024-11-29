package com.example.demo.service;

import com.example.demo.model.dto.ShowPaymentResponseDto;

public interface PaymentService {

    ShowPaymentResponseDto getPaymentInfo(Long userId);
}
