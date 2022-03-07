package com.example.paymentsservice.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private String methodName;
    private Double sum;
}
