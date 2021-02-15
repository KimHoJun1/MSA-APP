package com.unico.user.online.dto;

import lombok.Data;
import org.json.JSONObject;

import java.time.LocalDateTime;

@Data
public class UserDTO {
	String userId;
	String userPwd;
	String userNm;
	boolean useYn = true;
	LocalDateTime createdAt;
	LocalDateTime updatedAt;
}
