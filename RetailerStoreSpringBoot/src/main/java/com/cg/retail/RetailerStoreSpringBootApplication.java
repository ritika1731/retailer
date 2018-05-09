package com.cg.retail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cg.retail.entity.Customer;
import com.cg.retail.service.CustomerService;

@SpringBootApplication
//@ComponentScan("com.cg.service")
public class RetailerStoreSpringBootApplication implements ApplicationRunner{

	@Autowired
	CustomerService customerService;
	public static void main(String[] args) {
		SpringApplication.run(RetailerStoreSpringBootApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		customerService.addFirstCustomerAutomatically(new Customer("ritika","delhi","card"));
	}
}
