package com.unico.exchange.online.repository;

import com.unico.exchange.EntityMapper;
import com.unico.exchange.online.dto.DealDetailDTO;
import com.unico.exchange.online.entity.DealDetailEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DealDetailMapper extends EntityMapper<DealDetailEntity, DealDetailDTO> {
}
