package com.wlopezob.api_data_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class ApiDataV1Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiDataV1Application.class, args);
	}

}
