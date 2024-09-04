package com.indoo.pay.services;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayService {

    public final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "stock-reserved-topic", groupId = "pay-service-group")
    public void paymentListener(String orderData) {
        System.out.println(orderData+" Order Data");
        boolean paymentSuccess = processPayment(orderData);

        if (paymentSuccess) {
            kafkaTemplate.send("payment-success-topic", orderData);
        } else {
            kafkaTemplate.send("payment-failed-topic", orderData);
        }
    }
    private boolean processPayment(String orderData){
        return true;
    }
}
