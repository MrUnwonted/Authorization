package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
public class AdminSecurityConfig {

	@Bean
	protected UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().requestMatchers("/**").permitAll();
		return http.build();
		
		http.requestMatcher("/admin/**").authorizeRequests().anyRequest().hasAuthority("ADMIN");
	}
}
