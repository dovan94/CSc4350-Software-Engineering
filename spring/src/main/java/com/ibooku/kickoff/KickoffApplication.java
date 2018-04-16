package com.ibooku.kickoff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class KickoffApplication {

	public static void main(String[] args) {
		SpringApplication.run(KickoffApplication.class, args);
	}
	
	// Generate an instance of BCryptPasswordEncoder, must annotated with Bean
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}