package com.mockapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "MOCK API", version = "2.0", description = "Mock Api Information"))
public class MockApi {

	public static void main(String[] args) {
		SpringApplication.run(MockApi.class, args);
	}

}