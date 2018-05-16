package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
		//createBank();
	}
	
/*	private static void createBank()
	{
		System.out.println("add");
	    final String uri = "http://localhost:8082/createBank";
	    Bank newBank = new Bank();
	    RestTemplate restTemplate = new RestTemplate(20000);
	    String result = restTemplate.postForObject(uri, newBank,String.class);
	     
	    System.out.println(result);
	}*/
}
