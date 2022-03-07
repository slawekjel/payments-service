package com.example.paymentsservice.service;

import com.example.paymentsservice.model.Payment;
import com.example.paymentsservice.model.PaymentRequest;
import com.example.paymentsservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;


    public Payment orderPayment(PaymentRequest paymentRequest) {
        log.info("Ordering a payment by informing external company and getting details");
        var payment = informAboutNewPayment(paymentRequest);
        return createPayment(payment);
    }


    private Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    /*
    Example method which could execute request to endpoint provided by payments company to inform them about
    new payment request and get more details about it.
     */
    private Payment informAboutNewPayment(PaymentRequest paymentRequest) {
        return getPaymentDetails(paymentRequest);
    }


    /*
    Method which returns mocked info about payment details (should be provided by external company service(endpoint)).
     */
    private Payment getPaymentDetails(PaymentRequest paymentRequest) {
        return new Payment(paymentRequest.getMethodName(), "Fake Payment Provider Company",
                paymentRequest.getSum(), "http://www.fake-domain.com/fake/path/to/payment/url");
    }

}
