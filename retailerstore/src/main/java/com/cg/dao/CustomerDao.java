package com.cg.dao;

import com.cg.entity.Customer;

public interface CustomerDao {

	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);

//	public Customer deleteCustomer(int customerId);
	public Customer deleteCustomer(Customer customer);
}
