package com.cg.service;

import com.cg.dao.CustomerDao;
import com.cg.entity.Customer;


public class CustomerServiceImpl implements CustomerService{

	CustomerDao dao;
	
	
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
	public Customer deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customer);
	}

}
