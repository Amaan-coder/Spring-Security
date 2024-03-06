package com.tcser.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    
    //For in memmory user store
//    @Bean
//	public UserDetailsService detailsService() {
//		UserDetails user1 = User.builder().username("user1").password(encoder().encode("root")).roles("ADMIN").build();
//		UserDetails user2 = User.builder().username("user2").password(encoder().encode("root")).roles("USER").build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	
    
    // to get user from database
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
