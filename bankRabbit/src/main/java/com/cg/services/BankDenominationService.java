package com.cg.services;

import java.math.BigDecimal;

import com.cg.entity.Bank;
import com.cg.entity.BankDenomination;

public interface BankDenominationService {

	// public BankDenomination addDemomination(BigDecimal amount);

	public BankDenomination addDemomination(Bank bank,BigDecimal amount);
	
	
}
