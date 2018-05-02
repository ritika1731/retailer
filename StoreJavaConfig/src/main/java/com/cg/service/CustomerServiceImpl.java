package com.cg.service;

import com.cg.dao.CustomerDao;
import com.cg.entity.Customer;


public class CustomerServiceImpl implements CustomerService{

	CustomerDao dao;
	
	
	public CustomerServiceImpl(CustomerDao customerDao) {
	dao=customerDao;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.addCustomer(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.updateCustomer(customer);
	}

	@Override
	public int deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerId);
	}

}
