package com.unico.community.online.entity;


import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor
@Entity
@Builder
@Getter
@Table(name = "TB_UNICO_COMMUNITY_M")
public class CommunityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postNum;
    private String contents;
    private String userId;
    private String userNm;
    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @ColumnDefault("true")
    private boolean useYn;


}


