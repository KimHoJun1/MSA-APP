package com.unico.community.online.repository;

import com.querydsl.jpa.impl.JPAUpdateClause;
import com.unico.community.online.dto.CommunityDTO;
import com.unico.community.online.entity.QCommunityEntity;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Log
public class CommunityCRepositoryImpl implements CommunityCRepository {
    @Autowired
    EntityManager em;

    @Override
    public void updateUserNmByUserId(CommunityDTO dto) {


        QCommunityEntity qEntity = QCommunityEntity.communityEntity;

        JPAUpdateClause update = new JPAUpdateClause(em, qEntity)
                .where(qEntity.userId.eq(dto.getUserId()))
                .set(qEntity.userNm,dto.getUserNm());
        update.execute();
    }
}
