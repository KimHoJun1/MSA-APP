package com.unico.exchange.online.repository;


import com.unico.exchange.online.entity.AucDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AucDetailRepository extends JpaRepository<AucDetailEntity, Long> {

}
