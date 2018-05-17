package com.cg.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Bank;
import com.cg.exception.BankException;
import com.cg.services.BankServiceImpl;

@Controller
public class BankController {
	private final static Logger LOGGER = Logger.getLogger(BankController.class.getName());

	@Autowired
	BankServiceImpl bankService;

	/** BANK **/

	@PostMapping(path = "/createBank")
	public ResponseEntity<Bank> createBank(@RequestBody Bank bank) {
		Bank banks = bankService.createBank(bank);
		if ((bank.getAmount() != null)) {
			LOGGER.error("Null values present");
			throw new BankException("unable to insert,Null values present");
		} else {
			return new ResponseEntity<Bank>(banks, HttpStatus.CREATED);
		}
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

}
