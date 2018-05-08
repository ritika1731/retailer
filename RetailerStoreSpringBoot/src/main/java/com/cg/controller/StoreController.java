package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;
import com.cg.service.RetailerService;

@Controller
public class StoreController {
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private RetailerService retailerService;

	
	@RequestMapping(method=RequestMethod.GET,value="/addCust")
	@ResponseBody
	public Customer addCustomer()
	{
		Customer customer=new Customer(3,"shruti","mumbai","cash");
		customer=custService.addCustomer(customer);
		return customer;
		
	}
}
