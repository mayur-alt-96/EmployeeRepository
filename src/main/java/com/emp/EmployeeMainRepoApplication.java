package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.emp")
@EnableJpaRepositories(basePackages = { "com.emp.dao" })
@EntityScan(basePackages = { "com.emp.entity" })
public class EmployeeMainRepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMainRepoApplication.class, args);
	}
}

