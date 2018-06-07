package com.cg.services;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Bank;
import com.cg.exception.BankException;
import com.cg.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {
	private final static Logger LOGGER = Logger.getLogger(BankService.class.getName());
/*	@Autowired
	Environment env;*/
	@Autowired
	BankRepository bankRepo;

	public Bank createBank(@RequestBody Bank bank) {
		if ((bank.getAmount().intValue()) < 0) {
			throw new BankException("Id not found");

		} else {
			return bankRepo.save(bank);
		}
	}

	public Object getBankDetailsById(@RequestBody Bank bank) {

		Optional<Bank> banking = bankRepo.findById(bank.getId());
		if (banking.isPresent()) {
			Bank banks = banking.get();
			return banks;
		} else {
			throw new BankException("Id not found");

		}
	}

	public List<Bank> getBankDetails() {
		return bankRepo.findAll();
	}

}
