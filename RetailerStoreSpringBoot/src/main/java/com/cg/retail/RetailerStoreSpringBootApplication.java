package com.cg.retail;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cg.retail.entity.Customer;
import com.cg.retail.service.CustomerService;

@SpringBootApplication
//@ComponentScan("com.cg.service")
public class RetailerStoreSpringBootApplication {

	@Autowired
	CustomerService customerService;
	public static void main(String[] args) {
		SpringApplication.run(RetailerStoreSpringBootApplication.class, args);
		getCustomer();
		addCustomer();
		deleteCustomer();
		viewByCustomerId();
		updateCustomer();
	}

	private static void getCustomer()
	{
		System.out.println("view");
	    final String uri = "http://localhost:8082/viewCustomer";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);
	}
	
	private static void addCustomer()
	{
		System.out.println("add");
	    final String uri = "http://localhost:8082/addCustomer";
	    Customer newCustomer = new Customer("Adam", "goa" ,"CreditCard");
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.postForObject(uri, newCustomer,String.class);
	     
	    System.out.println(result);
	}
	
	private static void deleteCustomer()
	{
		System.out.println("delete");
	    
	    RestTemplate restTemplate = new RestTemplate();
	
	    ResponseEntity<String> exchange = restTemplate.exchange(
	            "http://localhost:8082/deleteCustomer",HttpMethod.DELETE,
	            new HttpEntity<Integer>(21),
	            String.class,"");
	
	System.out.println(exchange);
	
	}
	
	private static void viewByCustomerId()
	{
		System.out.println("view By Id");
		 RestTemplate restTemplate = new RestTemplate();
			
		    ResponseEntity<String> exchange1 = restTemplate.exchange(
		            "http://localhost:8082/viewCustomerById",HttpMethod.PUT,
		            new HttpEntity<Integer>(16),
		            String.class,"");
			System.out.println(exchange1);

	}
	
	private static void updateCustomer()
	{
		System.out.println("update");
		 RestTemplate restTemplate = new RestTemplate();
			
		    ResponseEntity<String> exchange2 = restTemplate.exchange(
		            "http://localhost:8082/updateCustomer",HttpMethod.PUT,
		            new HttpEntity<Integer>(16),
		            String.class,"");
		    
			System.out.println(exchange2);

	}
}
