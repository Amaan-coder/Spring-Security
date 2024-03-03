package com.tcser.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcser.springsecurity.dto.UserDto;
import com.tcser.springsecurity.dto.roleDto;

@Service
public class UserService {
	
private List<UserDto> store = new ArrayList<UserDto>();
	
	public UserService() {
		store.add(new UserDto("Mohd","Amaan","amaan@gmail.com","Admin123",roleDto.Admin));
		store.add(new UserDto("XYZ","Abc","abc@tcs.com","abc",roleDto.User));
	}

	public List<UserDto> getUser(){
		return this.store;
	}
	
	
}
