package com.cg.services;

import java.math.BigDecimal;

import com.cg.entity.ATM;
import com.cg.entity.AtmDenomination;

public interface AtmDenominationService {

	public AtmDenomination addDemomination(ATM atm,BigDecimal amount);

}
