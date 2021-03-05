package com.unico.community.online.post.entity;


import com.unico.community.online.postCatg.dto.PostCatgDTO;
import com.unico.community.online.postCatg.entity.PostCatgEntity;
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
@Table(name = "TB_POST_M")
public class PostEntity {

    @EmbeddedId
    private PostVO postVO;

    private long userNum;

    @ManyToOne(targetEntity = PostCatgEntity.class)
    @JoinColumn(name="postCatgUuid", referencedColumnName = "postCatgUuid", insertable = false, updatable = false)
    private PostCatgEntity postCatgEntity;
    public void setPostCatgEntity(PostCatgEntity postCatgEntity){
        if( postCatgEntity != null )
            postCatgEntity.getPostList().remove(this);

        this.postCatgEntity = postCatgEntity;
        this.postCatgEntity.getPostList().add(this);//양방향 관계설정
    }


    private String postTitle;
    private String postContents;
    @ColumnDefault("true")
    private boolean postUseYn;
    @Column
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column
    @UpdateTimestamp
    private LocalDateTime updatedAt;


}


