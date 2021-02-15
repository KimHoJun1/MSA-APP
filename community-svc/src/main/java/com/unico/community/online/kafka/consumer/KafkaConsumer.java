package com.unico.community.online.kafka.consumer;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.unico.community.online.entity.QCommunityEntity;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Map;

@Service
public class KafkaConsumer {

    EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    @KafkaListener(topics = "user-svc", groupId = "${kafka.consumer.groupId}")
    public void listen(Map<String,String> obj) {
        LOGGER.info("Received Messasge in group : " + obj.toString());

        QCommunityEntity qEntity = QCommunityEntity.communityEntity;

        new JPAUpdateClause(em, qEntity)
                .where(qEntity.userId.eq(obj.get("userId")))
                .set(qEntity.userNm,obj.get("userNm"))
                .execute();

    }
}
