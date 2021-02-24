package com.unico.chat.online.repository;

import com.unico.chat.online.dto.ChatDTO;
import com.unico.chat.online.entity.ChatEntity;
import com.unico.chat.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper extends EntityMapper<ChatEntity, ChatDTO> {
}
