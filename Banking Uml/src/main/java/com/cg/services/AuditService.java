package com.cg.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.cg.entity.Bank;
import com.cg.entity.Customer;

public class AuditService {

	public void updateCustomer() {
		
	    final String uri = "http://localhost:8082/update/{custId}/{pin}";
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("custId", "16");
	    params.put("pin", "7687");
	    Bank bank=new Bank(new BigDecimal(0));
	    Customer updatedCustomer = new Customer("abc", 1231, bank);
	    RestTemplate restTemplate = new RestTemplate();
	    
	    restTemplate.put ( uri, updatedCustomer, params);

	    
	    
	    
	    
	    
	     
	   
	   
	}
}
