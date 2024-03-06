package com.tcser.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tcser.springsecurity.config.UserConfig;
import com.tcser.springsecurity.dao.UserDao;
import com.tcser.springsecurity.dto.UserDto;
import com.tcser.springsecurity.dto.roleDto;

import jakarta.annotation.PostConstruct;


@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	@Autowired
	private UserConfig encoder;
	
	@PostConstruct
	public void AddUser() {
		UserDto users = new UserDto();
		users.setFirstName("Mohd");
		users.setLastName("Amaan");
		
	
		users.setEmail("amaan@tcs.com");
		users.setPassword(encoder.encoder().encode("admin"));
		users.setRole(roleDto.ADMIN);
		
		
		dao.save(users);
	}
	
	
private List<UserDto> store = new ArrayList<UserDto>();
	
	
//	public UserService() {
//		store.add(new UserDto("Mohd","Amaan","amaan@gmail.com","Admin123",roleDto.Admin));
//		store.add(new UserDto("XYZ","Abc","abc@tcs.com","abc",roleDto.User));
//	}

	public List<UserDto> getUser(){
		return dao.findAll();
	}


	public UserDto addUser(UserDto dto) {
		
		dto.setPassword(encoder.encoder().encode(dto.getPassword()));
		UserDto dto1 =dao.save(dto);
		return dto1; 
	}
	
	
}
