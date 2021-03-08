package com.unico.community.online.post.repository;


import com.unico.community.online.post.entity.PostEntity;
import com.unico.community.online.post.entity.PostVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, PostVO>, PostCRepository {
}
