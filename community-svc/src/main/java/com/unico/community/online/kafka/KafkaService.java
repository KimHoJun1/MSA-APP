package com.unico.community.online.kafka;

import com.querydsl.jpa.impl.JPAUpdateClause;
import com.unico.community.online.dto.CommunityDTO;
import com.unico.community.online.entity.QCommunityEntity;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Map;

@Service
@Log
public class KafkaService {
    private static final String TOPIC = "community-svc";
    @Autowired
    private KafkaTemplate<String, CommunityDTO> kafkaTemplate;
    EntityManager em;

    public void sendMessage(CommunityDTO dto) {
        this.kafkaTemplate.send(TOPIC, dto);
    }

    @KafkaListener(topics = "user-svc", groupId = "foo")
    public void consumeUserSvc(Map<String,String> obj) throws IOException {
        log.info("[kafka consume] topic : user-svc  groupId : communitySvc JSON : " + obj.toString());

        QCommunityEntity qEntity = QCommunityEntity.communityEntity;

        new JPAUpdateClause(em, qEntity)
                .where(qEntity.userId.eq(obj.get("userId")))
                .set(qEntity.userNm,obj.get("userNm"))
                .execute();

    }
}
