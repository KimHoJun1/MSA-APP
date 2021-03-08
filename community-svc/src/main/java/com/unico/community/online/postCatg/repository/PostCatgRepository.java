package com.unico.community.online.postCatg.repository;

import com.unico.community.online.postCatg.entity.PostCatgEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCatgRepository extends JpaRepository<PostCatgEntity, String> {
}
