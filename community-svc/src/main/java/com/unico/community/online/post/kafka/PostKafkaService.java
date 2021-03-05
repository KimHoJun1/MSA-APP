package com.unico.community.online.post.kafka;

import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.repository.PostRepository;
import lombok.extern.java.Log;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


@Service
@Transactional
@Log
public class PostKafkaService {
 /*   private static final String TOPIC = "community-svc";
    @Autowired
    private KafkaTemplate<String, PostDTO> kafkaTemplate;
    @Autowired
    PostRepository repository;

    public void sendMessage(PostDTO dto) {
        this.kafkaTemplate.send(TOPIC, dto);
    }

    @KafkaListener(topics = "user-svc", groupId = "community-svc")
    public void consumeUserSvc(String msg) throws IOException {
        log.info("[kafka consume] topic : user-svc  groupId : community-svc JSON : " + msg.toString());
        JSONObject json = new JSONObject(msg);
        PostDTO dto = new PostDTO();

        //repository.updateUserNmByUserId(dto);
    }*/
}
