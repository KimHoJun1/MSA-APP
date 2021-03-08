package com.unico.community.online.postCatg.dto;

import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.entity.PostEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PostCatgDTO {

    private String postCatgUuid;
    private String postCatgNm;
    private boolean postCatgUseYn;
    private String regnNm;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<PostDTO> postList;
}
