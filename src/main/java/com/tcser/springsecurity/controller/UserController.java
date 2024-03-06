package com.tcser.springsecurity.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcser.springsecurity.dto.UserDto;
import com.tcser.springsecurity.dto.roleDto;
import com.tcser.springsecurity.service.UserService;

@RestController
@RequestMapping("home")
public class UserController {
	@Autowired
	private UserService service;
	
	
	@GetMapping("/users")
	public List<UserDto> getUsers(){
		return service.getUser();
		
	}
	
	@GetMapping("/currentUser")
	public String loggedInUser(Principal principal) {
		return principal.getName();
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> adminUser(){
		return ResponseEntity.ok("Hi, I am a admin");
	}
	
	@GetMapping("/normal")
	public ResponseEntity<String> normalUser(){
		return ResponseEntity.ok("Hi, I am a normal user");
	}
	
	@GetMapping("/public")
	public ResponseEntity<String> publicUser(){
		return ResponseEntity.ok("Hi, I am a public user");
	}
	
	@GetMapping("/re")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/adduser")
	public UserDto addUser(@RequestBody UserDto dto){
		
		return service.addUser(dto);
	}
	
}
