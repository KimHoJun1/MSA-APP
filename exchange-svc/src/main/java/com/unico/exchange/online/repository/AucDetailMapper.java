package com.unico.exchange.online.repository;

import com.unico.exchange.EntityMapper;
import com.unico.exchange.online.dto.AucDetailDTO;
import com.unico.exchange.online.entity.AucDetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AucDetailMapper extends EntityMapper<AucDetailEntity, AucDetailDTO> {

}
