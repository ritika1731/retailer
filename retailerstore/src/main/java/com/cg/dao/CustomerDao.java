package com.cg.dao;

import com.cg.entity.Customer;

public interface CustomerDao {

	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);

	public boolean deleteCustomer(int customerId);

}
