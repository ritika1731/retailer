package com.cg.services;

import java.util.List;

import com.cg.entity.Customer;

public interface CustomerService {
	public Customer createCustomer(Customer customer);

	public Object getCustomerDetailsById(Customer customer);

	public List<Customer> getCustomerDetails();
}
