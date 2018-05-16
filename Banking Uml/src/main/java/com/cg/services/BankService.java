package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Bank;
import com.cg.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepo;

	public Bank createBank(@RequestBody Bank bank) {

		return bankRepo.save(bank);

	}

	public Object getBankDetailsById(@RequestBody Bank bank) {

		Object banking = bankRepo.findById(bank.getId());
		return banking;

	}

	public List<Bank> getBankDetails() {
		return bankRepo.findAll();
	}
}
