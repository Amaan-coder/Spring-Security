package com.tcser.springsecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcser.springsecurity.dto.UserDto;

@Repository
public interface UserDao extends JpaRepository<UserDto, Integer>{

}
