package com.cg.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.exception.BankException;
import com.cg.services.TransactionService;
import com.cg.set.TransactionRequest;

@Controller
public class TransactionController {
	private final static Logger LOGGER = Logger.getLogger(TransactionController.class.getName());

	@Autowired
	TransactionService transacService;

/*	@PostMapping(path = "/createTransaction")
	public ResponseEntity<Transaction> createAccount(@RequestBody final Account account, String TransactionType) {

		try {
			final Transaction transaction = transacService.createTransaction(account, TransactionType);
			return new ResponseEntity<Transaction>(transaction, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Failed to create Transaction");
		}

	}*/

	@GetMapping(path = "/generateTransactionReport")
	public ResponseEntity<?> generateTransactionReport() {

		try {
			List<Transaction> transactionList = transacService.generateTrasactionReport();
			return new ResponseEntity<List<Transaction>>(transactionList, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("failed to view customer");
		}

	}

}
