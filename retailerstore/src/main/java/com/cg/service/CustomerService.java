package com.cg.service;

import com.cg.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	//public Customer updateCustomer(int customerId);

	public Customer deleteCustomer(int customerId);
	//public Customer deleteCustomer(Customer customer);
}
