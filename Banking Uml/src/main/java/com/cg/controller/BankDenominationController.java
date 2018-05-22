package com.cg.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.BankDenomination;
import com.cg.services.BankDenominationService;
import com.cg.set.BankDenominationReq;

@Controller
public class BankDenominationController {

	@Autowired
	BankDenominationService bankdenoService;

	@PostMapping(path="/denominaton/{bankId}")
	public ResponseEntity<String> getDenomination(@PathVariable Integer bankId ) {
		
	bankdenoService.createDenomination(bankId);
		//System.out.println(bankdeno);
		return new ResponseEntity<String>("created",HttpStatus.OK);
	
	}
}
