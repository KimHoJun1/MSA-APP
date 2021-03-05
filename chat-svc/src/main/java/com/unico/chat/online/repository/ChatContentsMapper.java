package com.unico.chat.online.repository;

import com.unico.chat.EntityMapper;
import com.unico.chat.online.dto.ChatContentsDTO;
import com.unico.chat.online.entity.ChatContentsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatContentsMapper extends EntityMapper<ChatContentsEntity, ChatContentsDTO> {

}
