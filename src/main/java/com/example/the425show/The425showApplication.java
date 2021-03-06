package com.example.the425show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
public class The425showApplication {

	public static void main(String[] args) {
		SpringApplication.run(The425showApplication.class, args);
	}
}
