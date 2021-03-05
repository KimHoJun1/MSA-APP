package com.unico.community.online.post.repository;

import com.unico.community.online.post.dto.PostDTO;


public interface PostCRepository {
    public void updateUserNmByUserId(PostDTO dto);
}
