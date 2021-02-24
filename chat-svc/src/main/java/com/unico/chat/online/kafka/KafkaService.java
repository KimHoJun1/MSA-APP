/*
package com.unico.chat.online.kafka;

import com.unico.chat.online.dto.ChatDTO;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KafkaService {
    private static final String TOPIC = "chat-svc";

    @Autowired
    private KafkaTemplate<String, ChatDTO> kafkaTemplate;

    public void sendMessage(ChatDTO dto) {

        this.kafkaTemplate.send(TOPIC, dto);
    }

    @KafkaListener(topics = "chat-svc", groupId = "")
    public void consume(ConsumerRecord<String,Object> cr) throws IOException {

    }
}
*/
