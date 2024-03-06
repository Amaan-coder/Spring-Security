package com.tcser.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcser.springsecurity.dao.UserDao;
import com.tcser.springsecurity.dto.CustomUserDetail;
import com.tcser.springsecurity.dto.UserDto;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDao dao;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto dto= dao.findByEmail(username);
		if(dto==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetail(dto);
	}

}
