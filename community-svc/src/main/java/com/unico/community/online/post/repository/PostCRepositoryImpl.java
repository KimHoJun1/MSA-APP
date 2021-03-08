package com.unico.community.online.post.repository;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.dto.PostSearchDTO;
import com.unico.community.online.post.entity.PostEntity;
import com.unico.community.online.post.entity.QPostEntity;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Log
public class PostCRepositoryImpl implements PostCRepository {
    @PersistenceContext
    EntityManager em;
    @Autowired
    JPAQueryFactory qf;
    QPostEntity qEntity = QPostEntity.postEntity;



    @Override
    public void updateUserNmByUserId(PostDTO dto) {
    }

    @Override
    public long getMaxPostNum() {

        Long result = qf
                .select(qEntity.postVO.postNum.max().castToNum(Long.class).add(1))
                .from(qEntity)
                .fetchOne();

        return result;
    }

    @Override
    public List<PostEntity> findAllBySearchCondAndPaging(PostSearchDTO dto) {


        return qf
            .selectFrom(qEntity)
            .where(
                    qEntity.postVO.postCatgUuid.eq(dto.getPostCatgUuid()),
                    qEntity.postUseYn.eq(true),
                    qEntity.postTitle.contains(dto.getPostTitle()),
                    qEntity.postContents.contains(dto.getPostContents())
                    )
            .offset(dto.getPageable().getOffset())
            .limit(dto.getPageable().getPageSize())
            .orderBy(dto.getPageable().getSort().stream().toArray(OrderSpecifier[]::new))
            .fetch();


    }
}
