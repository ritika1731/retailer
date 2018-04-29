package com.cg.service;

import com.cg.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);

	public boolean deleteCustomer(int customerId);
}
