package com.cg.services;

import java.util.List;

import com.cg.entity.Customer;
import com.cg.set.CustomerReq;

public interface CustomerService {
	public Customer createCustomer(CustomerReq custReq);

	public Object getCustomerDetailsById(Customer customer);

	public List<Customer> getCustomerDetails();

	public Customer updateCustomer(Integer custId,Integer pin);
}
