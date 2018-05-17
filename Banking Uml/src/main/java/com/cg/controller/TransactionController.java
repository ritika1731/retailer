package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.exception.BankException;
import com.cg.services.TransactionService;
import com.cg.set.TransactionRequest;

@Controller
public class TransactionController {

	@Autowired
	TransactionService transacService;

	@PostMapping(path = "/createTransaction")
	public ResponseEntity<Transaction> createAccount(@RequestBody TransactionRequest transacReq) {

		try {
			Transaction transaction = transacService.createAccount(transacReq);
			return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Failed to create Transaction");
		}

	}

	@GetMapping(path = "/generateTransactionReport")
	public ResponseEntity<?> generateTransactionReport(@RequestBody Customer customer) {

		try {
			Object report = transacService.generateTrasactionReport(customer);
			return new ResponseEntity<Object>(report, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("id doesn't exists");
		}

	}

}
