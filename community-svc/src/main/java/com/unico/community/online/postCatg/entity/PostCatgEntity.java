package com.unico.community.online.postCatg.entity;


import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.entity.PostEntity;
import com.unico.community.online.post.entity.PostVO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor
@Entity
@Getter
@Table(name = "TB_POST_CATG_M")
public class PostCatgEntity {
    @Id
    private String postCatgUuid;
    private String postCatgNm;
    private boolean postCatgUseYn;
    private String regnNm;
    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //지연로딩 ( N + 1 방지 )
    @OneToMany(mappedBy = "postCatgEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PostEntity> postList = new ArrayList<>();

    public void addPostList(PostDTO dto){

        if( this.postList == null ) this.postList = new ArrayList<>();

        PostEntity entity = PostEntity.builder()
                .postCatgEntity(this) //연관관계 설정
                .postTitle(dto.getPostTitle())
                .postVO(PostVO.builder().postCatgUuid(this.postCatgUuid).postNum(dto.getPostVO().getPostNum()).build())
                .postContents(dto.getPostContents())
                .postUseYn(dto.isPostUseYn())
                .userNum(dto.getUserNum())
                .createdAt(LocalDateTime.now())
                .build();

        this.postList.add(entity);


    }


}
