package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.services.RefMoneyService;

@Controller
public class RefMoneyController {

	@Autowired
	RefMoneyService rfSer;

	@PostMapping(path = "/denominaton/{bankId}")
	public ResponseEntity<String> getDenomination(@PathVariable Integer bankId,@PathVariable Integer atmId) {

		rfSer.createBankDenomination(bankId);
		rfSer.createAtmDenomination(atmId);
		// System.out.println(bankdeno);
		return new ResponseEntity<String>("created", HttpStatus.OK);

	}
}
