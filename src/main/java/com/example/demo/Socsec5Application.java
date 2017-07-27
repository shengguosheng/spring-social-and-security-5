package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;

@SpringBootApplication(exclude=SocialWebAutoConfiguration.class)
public class Socsec5Application {

	public static void main(String[] args) {
		SpringApplication.run(Socsec5Application.class, args);
	}
}
