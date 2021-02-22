package com.unico.user.online.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unico.user.online.dto.UserDTO;
import com.unico.user.online.entity.UserEntity;
import com.unico.user.online.kafka.KafkaService;
import com.unico.user.online.repository.UserMapper;
import com.unico.user.online.repository.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Transactional
@Service
public class UserService {

	@Autowired
	KafkaService kafkaService;
	UserRepository repository;
	UserMapper mapper;

	
	public List<UserDTO> findAll(){
		return mapper.toDTOList(repository.findAll());
	}

	public UserDTO findOneById(String userId){return mapper.toDTO(repository.findById(userId).orElse(null));};

	public UserDTO saveUser(UserDTO dto){

		if( repository.existsById(dto.getUserId()) ){
			return null;
		} else {
			UserEntity entity = UserEntity.builder()
					.userId(dto.getUserId())
					.userPwd(dto.getUserPwd())
					.userNm(dto.getUserNm())
					.createdAt(LocalDateTime.now())
					.updatedAt(null)
					.build();



			return mapper.toDTO( repository.save( entity ) );
		}

	}

	public UserDTO updateUser( UserDTO dto){
		UserDTO result = null;

		if( repository.existsById(dto.getUserId()) ) {
			UserEntity entity = repository.findById(dto.getUserId()).orElse(null);
			entity.updateUserNm(dto.getUserNm());
			entity.updateUserPwd(dto.getUserPwd());
			entity.updateUseYn(dto.isUseYn());

			result = mapper.toDTO(entity);
			//kafkaService.sendMessage(result);
		}

		return result;
	}


	public boolean delete(String userId){
		if( repository.existsById( userId ) ){
			repository.deleteById(userId);
			return !repository.existsById(userId);
		} else {
			return false;
		}
	}
}
