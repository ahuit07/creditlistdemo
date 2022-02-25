package com.interest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.interest.demo")
public class InterestMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterestMicroServiceApplication.class, args);
	}

}
