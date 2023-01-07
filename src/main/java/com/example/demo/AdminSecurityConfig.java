package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().requestMatchers("/").permitAll();
		
		 http.authorizeHttpRequests((requests) -> requests
     			.requestMatchers("/admin/**").hasAnyRole("ADMIN")
     			.anyRequest().authenticated())
         .formLogin()
             .loginPage("/admin/login")
             .usernameParameter("email")
             .loginProcessingUrl("/admin/login")
             .defaultSuccessUrl("/admin/home")
             .permitAll()
         .and()
         .logout()
             .logoutUrl("/admin/logout")
             .logoutSuccessUrl("/");
		return http.build();    
 } 
	}

