package com.unico.chat.online.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ChatContentsDTO {

    private BigDecimal chtSeq;
    private long chtNum;
    private String chtLine;
    private LocalDateTime chtCreateTime;

}
