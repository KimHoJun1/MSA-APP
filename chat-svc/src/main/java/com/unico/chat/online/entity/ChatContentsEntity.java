package com.unico.chat.online.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "TB_CHT_CONTENTS_M")
public class ChatContentsEntity {
    @Id
    private BigDecimal chtSeq;
    private long chtNum;
    private String chtLine;
    @Column
    @CreationTimestamp
    private LocalDateTime chtCreateTime;
}
