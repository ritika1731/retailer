package com.cg.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Customer;
import com.cg.exception.BankException;
import com.cg.services.CustomerServiceImpl;
import com.cg.set.CustomerReq;

@Controller
public class CustomerController {
	private final static Logger LOGGER = Logger.getLogger(CustomerController.class.getName());

	@Autowired
	CustomerServiceImpl custService;

	/** CUSTOMER **/

	@PostMapping(path = "/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerReq custReq) {

		Customer customers = custService.createCustomer(custReq);
				
		return new ResponseEntity<Customer>(customers, HttpStatus.CREATED);

	}

	@GetMapping(path = "/viewAllCustomer")
	public ResponseEntity<?> viewAllCustomer() {

		try {
			List<Customer> customerList = custService.getCustomerDetails();
			return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("failed to view customer");
		}

	}

	@PutMapping(path = "/viewCustomerById")
	public ResponseEntity<Object> viewCustomerById(@RequestBody Customer customer) {
		try {
			Object customers = custService.getCustomerDetailsById(customer);

			return new ResponseEntity<Object>(customers, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOGGER.error("id doesn't exists");
			throw new BankException("id doesn't exists");
		}

	}
	
	@GetMapping(path = "/update/{custId}/{pin}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer custId,@PathVariable Integer pin) {

		Customer customer = custService.updateCustomer(custId,pin);

		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

}
