package com.produtos_servicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class TestePraticoLuigiCuriApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestePraticoLuigiCuriApplication.class, args);
	}

}
