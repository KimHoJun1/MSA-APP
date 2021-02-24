package com.unico.exchange.online.repository;


import com.unico.exchange.online.entity.DealDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealDetailRepository extends JpaRepository<DealDetailEntity, Long> {

}
