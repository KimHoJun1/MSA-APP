package com.unico.chat.online.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "TB_CHT_M")
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chtNum;
    private long hostUserNum;
    private long guestUserNum;
    @ColumnDefault("0")
    private int hostEndYn;
    @ColumnDefault("0")
    private int guestEndYn;

}


