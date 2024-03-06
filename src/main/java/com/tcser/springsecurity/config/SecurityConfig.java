package com.tcser.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/home/admin").hasRole("ADMIN")
						.requestMatchers("/home/adduser").hasRole("ADMIN")
						.requestMatchers("/home/normal").hasRole("USER").requestMatchers("/home/**").permitAll()
						.anyRequest().authenticated()).httpBasic(basic->basic.getClass());
		return http.build();

	}

}
