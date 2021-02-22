package com.unico.community.online.repository;

import com.unico.community.online.dto.CommunityDTO;

public interface CommunityCRepository {
    public void updateUserNmByUserId(CommunityDTO dto);
}
