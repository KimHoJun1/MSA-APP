package com.unico.community.online.post.repository;

import com.querydsl.jpa.impl.JPAUpdateClause;
import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.entity.QPostEntity;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

@Log
public class PostCRepositoryImpl implements PostCRepository {
    @Autowired
    EntityManager em;

    @Override
    public void updateUserNmByUserId(PostDTO dto) {
    	QPostEntity qEntity = QPostEntity.postEntity;
//
//        JPAUpdateClause update = new JPAUpdateClause(em, qEntity)
//                .where(qEntity.userId.eq(dto.getUserId()))
//                .set(qEntity.userNm,dto.getUserNm());
//        update.execute();
    }
}
