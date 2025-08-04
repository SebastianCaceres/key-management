package com.example.key_management;

import com.example.key_management.services.KeyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AutoConfiguration
public class KeyManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeyManagementApplication.class, args);
	}
	@Bean
	public CommandLineRunner initData(KeyService keyService) {
		return args -> {
			keyService.initializeSampleKeys();
		};
	}

}
