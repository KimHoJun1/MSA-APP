package com.unico.community.online.post.repository;

import com.unico.community.online.post.dto.PostDTO;
import com.unico.community.online.post.entity.PostEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper{

    @Mapping(target="postVO", source = "postVO")
    PostDTO toPostDTO(PostEntity entity);
}
