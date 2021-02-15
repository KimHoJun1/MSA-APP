package com.unico.community.online.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommunityDTO {

    private long postNum;
    private String contents;
    private String userId;
    private String userNm;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean useYn;
}
