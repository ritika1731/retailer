  package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cg.StoreApplicationTests;
import com.cg.entity.Customer;
import com.cg.service.CustomerService;
import com.cg.service.GoodsService;
import com.cg.service.RetailerService;
import com.cg.service.SupplierService;

@Controller
public class StoreController {

	@Autowired
	static
	CustomerService custService;

	@Autowired
	static
	GoodsService goodService;

	@Autowired
	static
	RetailerService retailerService;

	@Autowired
	static
	SupplierService supplierService;
	
	@Autowired
	static
	StoreApplicationTests  test;

	public static void main(String[] args) {

	//entitymanager.getTransaction( ).begin( );

	      Customer customer= new Customer( ); 
	      customer.setCustomerId(101);
	      customer.setCustomerName("ritika");
	      customer.setCustomerAddress("delhi" );
	      customer.setPaymentMode("cash");      
	      customer=custService.addCustomer(customer);

	     

	}

}
