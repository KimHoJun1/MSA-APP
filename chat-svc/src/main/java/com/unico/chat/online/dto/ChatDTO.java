package com.unico.chat.online.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatDTO {

    private long chtNum;
    private long hostUserNum;
    private long guestUserNum;
    private int hostEndYn;
    private int guestEndYn;

}
