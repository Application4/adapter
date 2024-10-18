package com.javatechie.service;
import com.javatechie.processor.PaymentProcessor;
import com.javatechie.request.PaymentRequest;
import com.javatechie.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private final Map<String, PaymentProcessor> paymentProcessors;

    public PaymentService(List<PaymentProcessor> processors) {
        this.paymentProcessors = processors.stream()
                .collect(Collectors.toMap(processor -> processor.getClass().getSimpleName(), Function.identity()));
    }

    /**
     * Process payment using the specified payment gateway
     *
     * @param gateway payment gateway
     * @param request payment request
     * @return payment response
     */
    public PaymentResponse processPayment(String gateway, PaymentRequest request) {
        PaymentProcessor paymentProcessor = paymentProcessors.get(gateway + "PaymentAdapter");
        if (paymentProcessor == null) {
            throw new IllegalArgumentException("Unsupported payment gateway: " + gateway);
        }
        return paymentProcessor.processPayment(request);
    }
}