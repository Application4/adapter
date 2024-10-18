package com.javatechie.processor;


import com.javatechie.request.PaymentRequest;
import com.javatechie.response.PaymentResponse;

public interface PaymentProcessor {

    PaymentResponse processPayment(PaymentRequest paymentRequest);
}