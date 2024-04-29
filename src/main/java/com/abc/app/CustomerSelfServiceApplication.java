package com.abc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("com.abc.model")
@SpringBootApplication
@EnableJpaRepositories("com.abc.repository")
@ComponentScan("com.abc")
public class CustomerSelfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSelfServiceApplication.class, args);
	}

}
