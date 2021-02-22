package com.unico.community.online.kafka;

import com.querydsl.jpa.impl.JPAUpdateClause;
import com.unico.community.online.dto.CommunityDTO;
import com.unico.community.online.entity.QCommunityEntity;
import com.unico.community.online.repository.CommunityRepository;
import lombok.extern.java.Log;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.IOException;


@Service
@Transactional
@Log
public class KafkaService {
    private static final String TOPIC = "community-svc";
    @Autowired
    private KafkaTemplate<String, CommunityDTO> kafkaTemplate;
    @Autowired
    CommunityRepository repository;

    public void sendMessage(CommunityDTO dto) {
        this.kafkaTemplate.send(TOPIC, dto);
    }

    @KafkaListener(topics = "user-svc", groupId = "community-svc")
    public void consumeUserSvc(String msg) throws IOException {
        log.info("[kafka consume] topic : user-svc  groupId : community-svc JSON : " + msg.toString());
        JSONObject json = new JSONObject(msg);
        CommunityDTO dto = new CommunityDTO();

        dto.setUserId(""+json.get("userId"));
        dto.setUserNm(""+json.get("userNm"));

        repository.updateUserNmByUserId(dto);
    }
}
