package com.cg.controller;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Account;
import com.cg.exception.BankException;
import com.cg.services.AccountService;
import com.cg.set.AccountRequest;

@Controller
public class AccountController {
	private final static Logger LOGGER = Logger.getLogger(AccountController.class.getName());

	@Autowired
	AccountService accService;

	/** ACCOUNT **/

	@PostMapping(path = "/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody AccountRequest acctReq) {

		try {
			Account accounts = accService.createAccount(acctReq);
			return new ResponseEntity<Account>(accounts, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Failed to create Account");
		}

	}

	@PutMapping(path = "/viewAccountById")
	public ResponseEntity<Object> viewAccountById(@RequestBody Account account) {
		try {
			Object accounts = accService.getAccountDetailsById(account);
			return new ResponseEntity<Object>(accounts, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Id doesn't exist");
		}

	}

	@PostMapping(path = "/depositMoney/{accountId}/{amount}")
	public ResponseEntity<Account> depositMoney(@PathVariable Integer accountId, @PathVariable BigDecimal amount) {
		try {
			Account account = accService.depositMoney(accountId, amount);
			return new ResponseEntity<Account>(account, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Failed to deposit");
		}

	}

	@PostMapping(path = "/withdrawMoney/{accountId}/{amount}")
	public ResponseEntity<Account> withdrawMoney(@PathVariable Integer accountId, @PathVariable BigDecimal amount) {
		try {
			Account account = accService.withdraw(accountId, amount);
			return new ResponseEntity<Account>(account, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Failed to withdraw");
		}

	}

}
