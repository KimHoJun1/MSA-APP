package com.unico.user.online.controller;

import com.unico.user.online.service.UserService;
import com.unico.user.online.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping( "/users" )
@RestController
public class UsersController {
	
	UserService service;


	@GetMapping( value = "/v1" )
	public List<UserDTO> findAll() {
		return service.findAll();
	}

	@GetMapping(value="/one/v1/{userId}")
	public UserDTO findOneById(@PathVariable  String userId){return service.findOneById(userId);};

	@PostMapping(value = "/v1")
	public UserDTO saveUser(@RequestBody UserDTO dto){
		return service.saveUser(dto);
	}

	//request body에 담긴 정보는 @RequestBody 어노테이션으로 받을 수 있음.
	@PutMapping(value = "/v1")
	public UserDTO updateUser(@RequestBody UserDTO dto){
		return service.updateUser(dto);
	}

	//URI에 있는 {변수명} 은 RestController에서 @PathVariable로 받을 수 있음
	@DeleteMapping(value = "/v1/{userId}")
	public boolean delete(@PathVariable String userId){
		return service.delete(userId);
	}
}
