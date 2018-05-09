package com.cg.retail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.retail.entity.Customer;
import com.cg.retail.service.CustomerService;

@RestController

public class StoreController {
	
	@Autowired
	private CustomerService custService;
	
	
	@PostMapping(path="/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer)
	{
		
		return custService.addCustomer(customer);
		
	}
	
	@GetMapping(path="/viewCustomer")
	public List<Customer> viewCustomer()
	{
		
		return custService.getCustomer();
		
	}
	
	@DeleteMapping(path="/deleteCustomer")
	public Customer deleteCustomer( @RequestBody Integer customerId)
	{
		return custService.deleteCustomer(customerId);
	}
	
	@PutMapping(path="/updateCustomer")
	public Customer updateCustomer(@RequestBody Integer customerId)
	{
		return custService.updateCustomer(customerId);
	}
}
