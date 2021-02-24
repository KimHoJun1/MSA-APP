package com.unico.exchange.online.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DealDetailDTO {

    private long dealNum;
    private long aucNum;
    private String dealTitle;
    private String dealStatusCd;
    private int goodsCount;
    private LocalDateTime dealStartTime;
    private LocalDateTime dealEndTime;
    private String text;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String regnNm;
    private String image1Path;
    private String image2Path;
    private String image3Path;
    private String image4Path;


}
