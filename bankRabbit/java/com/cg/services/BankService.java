package com.cg.services;

import java.util.List;

import com.cg.entity.Bank;

public interface BankService {
	public Bank createBank(Bank bank);

	public Object getBankDetailsById(Bank bank);

	public List<Bank> getBankDetails();
}
