package com.unico.user.online.repository;

import com.unico.user.EntityMapper;
import com.unico.user.online.dto.UserDTO;
import com.unico.user.online.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserEntity, UserDTO> {


}
