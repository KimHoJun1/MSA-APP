package com.unico.user.online.kafka;

import com.unico.user.online.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class KafkaService {
    private static final String TOPIC = "user-svc";

    @Autowired
    private KafkaTemplate<String, UserDTO> kafkaTemplate;

    public void sendMessage(UserDTO dto) {

        this.kafkaTemplate.send(TOPIC, dto);
    }

    @KafkaListener(topics = "community-svc", groupId = "foo")
    public void consume(ConsumerRecord<String,Object> cr) throws IOException {

    }
}
