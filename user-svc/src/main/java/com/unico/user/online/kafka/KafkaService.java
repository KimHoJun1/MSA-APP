package com.unico.user.online.kafka;

import lombok.extern.java.Log;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Log
public class KafkaService {
    private static final String TOPIC = "user-svc";
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(JSONObject json) {
        log.info("[" + TOPIC + "] 메시지 발행 : " + json.toString());
        this.kafkaTemplate.send(TOPIC, json.toString());
    }

    @KafkaListener(topics = "community-svc", groupId = "user-svc")
    public void consume(String jsonStr) throws IOException {
        log.info("[ community-svc ] 메시지 수신 : " + jsonStr);

    }
}
