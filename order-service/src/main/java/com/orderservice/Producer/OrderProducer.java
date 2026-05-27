package com.orderservice.Producer;

import com.orderservice.Model.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class OrderProducer {

    private static final String TOPIC = "order-created";

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void publishOrderEvent(OrderEvent event) {
        log.info("Publishing order event: {}", event);
        kafkaTemplate.send(TOPIC, event);
    }
}
