package com.unico.community.online.post.repository;

import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.dto.PostSearchDTO;
import com.unico.community.online.post.entity.PostEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PostCRepository {
    public List<PostEntity> findAllBySearchCondAndPaging(PostSearchDTO dto);
    public void updateUserNmByUserId(PostDTO dto);
    public long getMaxPostNum();
}
