package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.services.BankService;
import com.cg.services.CustomerService;

@Controller
public class BankingController {

	@Autowired
	BankService bankService;

	@Autowired
	CustomerService custService;

	/** BANK **/

	@PostMapping(path = "/createBank")
	public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
		Bank banks = bankService.createBank(bank);
		return new ResponseEntity<Bank>(banks, HttpStatus.CREATED);

	}

	@GetMapping(path = "/viewAllBAnk")
	public ResponseEntity<?> viewAllBAnk() {

		List<Bank> bankList = bankService.getBankDetails();
		return new ResponseEntity<List<Bank>>(bankList, HttpStatus.OK);

	}

	@PutMapping(path = "/viewBankById")
	public ResponseEntity<Object> viewBankById(@RequestBody Bank bank) {
		Object banks = bankService.getBankDetailsById(bank);
		return new ResponseEntity<Object>(banks, HttpStatus.OK);

	}

	/** CUSTOMER **/

	@PostMapping(path = "/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer customers = custService.createCustomer(customer);
		return new ResponseEntity<Customer>(customers, HttpStatus.CREATED);

	}

	@GetMapping(path = "/viewAllCustomer")
	public ResponseEntity<?> viewAllCustomer() {

		List<Customer> customerList = custService.getCustomerDetails();
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);

	}

	@PutMapping(path = "/viewCustomerById")
	public ResponseEntity<Object> viewCustomerById(@RequestBody Customer customer) {
		Object customers = custService.getCustomerDetailsById(customer);
		return new ResponseEntity<Object>(customers, HttpStatus.OK);

	}

}
