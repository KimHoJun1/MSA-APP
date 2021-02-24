package com.unico.chat.online.repository;


import com.unico.chat.online.entity.ChatContentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ChatContentsRepository extends JpaRepository<ChatContentsEntity, BigDecimal> {

}
