package com.javatechie.adapter;

import com.javatechie.processor.PaymentProcessor;
import com.javatechie.request.PaymentRequest;
import com.javatechie.response.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StripePaymentAdapter implements PaymentProcessor {

    private static final Logger log = LoggerFactory.getLogger(StripePaymentAdapter.class);

    /**
     * Process payment using Stripe payment gateway
     *
     * @param paymentRequest payment request
     * @return payment response
     */
    @Override
    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        log.debug("Processing Stripe payment request: {}", paymentRequest);
        return new PaymentResponse(true, new Random().nextLong(1000000000L));
    }

}