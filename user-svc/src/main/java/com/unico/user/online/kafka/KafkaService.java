package com.unico.user.online.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaService {
    private static final String TOPIC = "user-svc";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        System.out.println(String.format("Produce message : %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }

    @KafkaListener(topics = "user-svc", groupId = "user-svc")
    public void consume(String message) throws IOException {
        System.out.println(String.format("Consumed message : %s", message));
    }
}
