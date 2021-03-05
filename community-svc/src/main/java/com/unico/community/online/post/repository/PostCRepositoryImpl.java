package com.unico.community.online.post.repository;

import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.entity.PostEntity;
import com.unico.community.online.post.entity.QPostEntity;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Log
public class PostCRepositoryImpl implements PostCRepository {
    @PersistenceContext
    EntityManager em;



    @Override
    public void updateUserNmByUserId(PostDTO dto) {
//
//        JPAUpdateClause update = new JPAUpdateClause(em, qEntity)
//                .where(qEntity.userId.eq(dto.getUserId()))
//                .set(qEntity.userNm,dto.getUserNm());
//        update.execute();
    }

    @Override
    public long getMaxPostNum() {

        QPostEntity qEntity = QPostEntity.postEntity;
        JPAQueryFactory qf = new JPAQueryFactory(em);
        Long result = qf.select(qEntity.postVO.postNum.max().castToNum(Long.class).add(1))
                .from(qEntity)
                .fetchOne();

        return result;
    }
}
