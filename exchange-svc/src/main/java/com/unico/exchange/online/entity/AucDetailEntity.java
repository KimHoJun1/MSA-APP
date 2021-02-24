package com.unico.exchange.online.entity;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "TB_AUC_DETAIL_M")
public class AucDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long aucNum;
    private int aucStartPrice;
    private int aucEndPrice;

}
