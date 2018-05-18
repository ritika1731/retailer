package com.cg.services;

import java.math.BigDecimal;

import com.cg.entity.ATM;
import com.cg.set.ATMRequest;

public interface ATMService {

	public ATM createATM(ATMRequest atmReq);

	public ATM addMoneyFromBank(BigDecimal amount, Integer atmId);

	//public ATM withdraw(BigDecimal amount, Integer atmId);
}
