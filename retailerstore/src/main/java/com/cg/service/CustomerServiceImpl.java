package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.CustomerDao;
import com.cg.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
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
	public boolean deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.deleteCustomer(customerId);
	}

}
