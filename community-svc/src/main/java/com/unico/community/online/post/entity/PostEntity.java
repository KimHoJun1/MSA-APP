package com.unico.community.online.post.entity;


import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.postCatg.entity.PostCatgEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor( access = AccessLevel.PROTECTED )
@AllArgsConstructor
@Entity
@Getter
@Table(name = "TB_POST_M")
public class PostEntity {

    @EmbeddedId
    @Column(unique = true, nullable = false)
    private PostVO postVO;

    private long userNum;

    @ManyToOne(fetch=FetchType.LAZY, optional = true)
    @JoinColumn(name="postCatgUuid", referencedColumnName = "postCatgUuid", insertable = false, updatable = false)
    private PostCatgEntity postCatgEntity;

    public static PostEntityBuilder builder() {
        return new PostEntityBuilder();
    }

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


    public void update(PostDTO dto){

        if(!dto.getPostContents().equals("") && !this.postContents.equals(dto.getPostContents())){
            this.postContents = dto.getPostContents();
        }

        if(!dto.getPostTitle().equals("") && !this.postTitle.equals(dto.getPostTitle())){
            this.postTitle = dto.getPostTitle();
        }

        if(this.isPostUseYn() != dto.isPostUseYn()){
            this.postUseYn = dto.isPostUseYn();
        }

        this.updatedAt = updatedAt.now();

    }

    public static class PostEntityBuilder {
        private PostVO postVO;
        private long userNum;
        private PostCatgEntity postCatgEntity;
        private String postTitle;
        private String postContents;
        private boolean postUseYn;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        PostEntityBuilder() {
        }

        public PostEntityBuilder postVO(PostVO postVO) {
            this.postVO = postVO;
            return this;
        }

        public PostEntityBuilder userNum(long userNum) {
            this.userNum = userNum;
            return this;
        }

        public PostEntityBuilder postCatgEntity(PostCatgEntity postCatgEntity) {
            this.postCatgEntity = postCatgEntity;
            return this;
        }

        public PostEntityBuilder postTitle(String postTitle) {
            this.postTitle = postTitle;
            return this;
        }

        public PostEntityBuilder postContents(String postContents) {
            this.postContents = postContents;
            return this;
        }

        public PostEntityBuilder postUseYn(boolean postUseYn) {
            this.postUseYn = postUseYn;
            return this;
        }

        public PostEntityBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PostEntityBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public PostEntity build() {
            return new PostEntity(postVO, userNum, postCatgEntity, postTitle, postContents, postUseYn, createdAt, updatedAt);
        }

        public String toString() {
            return "PostEntity.PostEntityBuilder(postVO=" + this.postVO + ", userNum=" + this.userNum + ", postCatgEntity=" + this.postCatgEntity + ", postTitle=" + this.postTitle + ", postContents=" + this.postContents + ", postUseYn=" + this.postUseYn + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
        }
    }
}


