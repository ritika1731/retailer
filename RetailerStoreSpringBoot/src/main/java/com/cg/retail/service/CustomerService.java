package com.cg.retail.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.CustomerDao;
import com.cg.retail.entity.Customer;
import com.cg.retail.exception.StoreException;

@Service
public class CustomerService {
	private final static Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

	
	@Autowired
	CustomerDao custDao;

	public Customer addCustomer(@RequestBody Customer customer) {
		return custDao.save(customer);

	}

	public Customer updateCustomer(@RequestBody Integer customerId) {
		Customer customer;
		try {
			customer = custDao.getOne(customerId);
			customer.setPaymentMode("Cash");
			return custDao.save(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new StoreException("Id not found");
		}
		

	}

	public Customer deleteCustomer(@RequestBody Integer customerId) {
		
	
		try {
			Customer customer = new Customer(customerId);
			custDao.deleteById(customerId);
			return customer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new StoreException("Id not found");
 
		}

	}

	public List<Customer> getCustomer() {
		return custDao.findAll();
	}

	public Object viewbyId(@RequestBody Customer customer) {
		LOGGER.info(customer.getCustomerId());

		try {
			Object cust = custDao.findById(customer.getCustomerId());
					LOGGER.info(cust);
			return cust;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new StoreException("Id not found");

		}
	}

	public void addFirstCustomerAutomatically(Customer customer) {

		custDao.save(customer);
	}

	

}
