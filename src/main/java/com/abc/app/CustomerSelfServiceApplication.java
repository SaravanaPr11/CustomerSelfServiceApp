package com.abc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan("com.abc.model")
@SpringBootApplication
public class CustomerSelfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSelfServiceApplication.class, args);
	}

}
