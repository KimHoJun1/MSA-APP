package com.unico.community.online.repository;

import com.unico.community.EntityMapper;
import com.unico.community.online.dto.CommunityDTO;
import com.unico.community.online.entity.CommunityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommunityMapper extends EntityMapper<CommunityEntity, CommunityDTO> {
}
