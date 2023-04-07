package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableJpaRepositories("com.example.productservice.*")
// @ComponentScan("com.example.productservice.*")
// @EntityScan("com.example.productservice.*")
// @ComponentScan(basePackages = "com.example.productservice")
public class ProductserviceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

}
