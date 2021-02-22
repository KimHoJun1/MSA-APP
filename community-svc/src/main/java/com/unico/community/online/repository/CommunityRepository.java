package com.unico.community.online.repository;


import com.unico.community.online.entity.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<CommunityEntity, Long>, CommunityCRepository {
}
