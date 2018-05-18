package com.cg.banking;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.cg.controller.CustomerController;
import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.repository.BankRepository;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AtmApplicationTests {
	@Autowired
	BankRepository bankRepo;
	@Autowired
	CustomerController controller;

	@Test
	public void custCreate() {

		final String uri = "http://localhost:8080/createCustomer";
		Optional<Bank> ob = bankRepo.findById(1);
		Bank obj = ob.get();
		Customer newCustomer = new Customer("Adam", 1212, obj);
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(uri, newCustomer, String.class);

		System.out.println(result);
		assertEquals(result, controller.createCustomer(newCustomer));
	}

	@Test
	public void viewCust() {

		final String uri = "http://localhost:8080/viewAllCustomer";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		System.out.println(result);
		assertEquals(result, controller.viewAllCustomer());
	}
}
