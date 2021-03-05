package com.unico.community.online.postCatg.repository;

import com.unico.community.online.postCatg.dto.PostCatgDTO;
import com.unico.community.online.postCatg.entity.PostCatgEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostCatgMapper {
    @Mapping(target="postList", source = "postList")
    PostCatgDTO toPostCatgDTO(PostCatgEntity entity);
}
