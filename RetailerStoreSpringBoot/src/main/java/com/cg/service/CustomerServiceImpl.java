package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.CustomerDao;
import com.cg.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao dao;
	
	
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
	public Customer deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerId);
	}

}
