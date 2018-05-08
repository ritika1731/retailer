package com.cg.RetailerStoreSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class RetailerStoreSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailerStoreSpringBootApplication.class, args);
	}
}
