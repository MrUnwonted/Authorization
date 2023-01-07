package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {

	private UserRepository repo;
	
	public DatabaseLoader(UserRepository repo) {
		this.repo = repo;
	}
	
	@Bean
	public CommandLineRunner initializeDatabase() {

		return args -> {
			User user1 = new User("arjun@gmail.com", "123", Role.ADMIN);
			User user2 = new User("achu@gmail.com", "123", Role.ADMIN);
			User user3 = new User("abhi@gmail.com", "123", Role.USER);
			User user4 = new User("dam@gmail.com", "123", Role.USER);
			
			repo.saveAll(List.of(user1,user2,user3,user4));
			
			System.out.println("Sample Database Initialized");
		};
		
	}
}