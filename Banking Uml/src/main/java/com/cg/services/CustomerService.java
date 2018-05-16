package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Customer;
import com.cg.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custRepo;

	public Customer createCustomer(@RequestBody Customer customer) {

		return custRepo.save(customer);

	}

	public Object getCustomerDetailsById(@RequestBody Customer customer) {

		Object cust = custRepo.findById(customer.getCustomerId());
		return cust;

	}

	public List<Customer> getCustomerDetails() {
		return custRepo.findAll();
	}
}
