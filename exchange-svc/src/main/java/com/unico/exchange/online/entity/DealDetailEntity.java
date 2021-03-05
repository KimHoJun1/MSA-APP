package com.unico.exchange.online.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "TB_DEAL_DETAIL_M")
public class DealDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long dealNum;
    private long aucNum;
    private String dealTitle;
    private String dealStatusCd;
    private int goodsCount;
    private LocalDateTime dealStartTime;
    private LocalDateTime dealEndTime;
    private String text;
    @Column
    @CreationTimestamp
    private LocalDateTime createTime;
    @Column
    @UpdateTimestamp
    private LocalDateTime updateTime;
    private String regnNm;
    private String image1Path;
    private String image2Path;
    private String image3Path;
    private String image4Path;

}


