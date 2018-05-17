package com.cg.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.ATM;
import com.cg.exception.BankException;
import com.cg.services.ATMService;
import com.cg.set.ATMRequest;

@Controller
public class ATMController {

	@Autowired
	ATMService atmService;

	@PostMapping(path = "/createAtm")
	public ResponseEntity<ATM> createAtm(@RequestBody ATMRequest atmReq) {

		ATM atm = atmService.createATM(atmReq);
		if ((atm.getAmount()!= null)) {
			return new ResponseEntity<ATM>(atm, HttpStatus.CREATED);
		}
		else
		{
			throw new BankException("null value not accepted");
		}

	}

	@PostMapping(path = "/addMoneyBank/{amount}/{atmId}")
	public ResponseEntity<String> addMoneyBank(@PathVariable BigDecimal amount, @PathVariable Integer atmId) {

		try {
			ATM atm = atmService.addMoneyFromBank(amount, atmId);
			return new ResponseEntity<String>(atm.toString(), HttpStatus.OK);
		} catch (Exception e) {
			throw new BankException("Failed to transfer");

		}
	}

	@PostMapping(path = "/withdrawAtmMoney/{atmId}/{amount}")
	public ResponseEntity<ATM> withdrawATMMoney(@PathVariable Integer atmId, @PathVariable BigDecimal amount) {
		try {
			ATM atm = atmService.withdraw(amount, atmId);
			return new ResponseEntity<ATM>(atm, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Failed to withdraw");
		}
	}
}
