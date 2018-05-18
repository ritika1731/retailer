package com.cg.services;

import static org.assertj.core.api.Assertions.byLessThan;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.mockito.internal.matchers.LessThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.ATM;
import com.cg.entity.Account;
import com.cg.entity.Bank;
import com.cg.exception.BankException;
import com.cg.repository.ATMRepository;
import com.cg.repository.AccountRepository;
import com.cg.repository.BankRepository;
import com.cg.set.ATMRequest;
import com.cg.set.TransactionRequest;

@Service
public class ATMServiceImpl implements ATMService {
	private final static Logger LOGGER = Logger.getLogger(ATMService.class.getName());

	@Autowired
	ATMRepository atmRepo;
	@Autowired
	BankRepository bankRepo;
	@Autowired
	AccountRepository accRepo;
	@Autowired
	TransactionService transactionService;
	

	@Override
	public ATM createATM(ATMRequest atmReq) {

		Optional<Bank> atmOpt = bankRepo.findById(atmReq.getBankId());
		Bank bank = atmOpt.get();

		ATM atm = atmReq.getAtm();
		atm.setBank(bank);

		return atmRepo.save(atm);
	}

	@Override
	public ATM addMoneyFromBank(BigDecimal amount, Integer atmId) {
		Optional<ATM> atmOp = atmRepo.findById(atmId);
		ATM atm = atmOp.get();
		Optional<Bank> bankOpt = bankRepo.findById(atm.getBank().getId());
		Bank bank = bankOpt.get();
		try {
			BigDecimal amounts = atm.getAmount().add(amount);
			atm.setAmount(amounts);
			atmRepo.save(atm);
			BigDecimal bankAmount = bank.getAmount().subtract(amount);
			bank.setAmount(bankAmount);
			bankRepo.save(bank);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Insufficient amount");
		}
		return atm;
	}

	

}
