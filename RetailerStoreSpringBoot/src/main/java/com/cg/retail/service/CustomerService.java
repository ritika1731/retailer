package com.cg.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.CustomerDao;
import com.cg.retail.entity.Customer;

@Service
public class CustomerService {
	@Autowired
	CustomerDao custDao;

	public Customer addCustomer(@RequestBody Customer customer) {
		return custDao.save(customer);

	}

	public Customer updateCustomer(@RequestBody Integer customerId) {
		Customer customer = custDao.getOne(customerId);
		customer.setPaymentMode("Cash");
		return custDao.save(customer);

	}

	public Customer deleteCustomer(@RequestBody Integer customerId) {
		Customer customer = new Customer(customerId);
		custDao.deleteById(customerId);
		return customer;

	}

	public List<Customer> getCustomer() {
		return custDao.findAll();
	}

	public Object viewbyId(@RequestBody Customer customer) {
		System.out.println(customer.getCustomerId());

		Object cust = custDao.findById(customer.getCustomerId());
		System.out.println(cust);
		return cust;
	}

	public void addFirstCustomerAutomatically(Customer customer) {

		custDao.save(customer);
	}

	

}
