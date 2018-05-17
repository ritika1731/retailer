package com.cg.services;

import static org.assertj.core.api.Assertions.byLessThan;

import java.math.BigDecimal;
import java.util.Optional;

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

@Service
public class ATMServiceImpl implements ATMService {

	@Autowired
	ATMRepository atmRepo;
	@Autowired
	BankRepository bankRepo;
	@Autowired
	AccountRepository accRepo;

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

	@Override
	public ATM withdraw(BigDecimal amount, Integer atmId) {
		Optional<ATM> atmOp = atmRepo.findById(atmId);
		ATM atm = atmOp.get();
		Optional<Account> accOpt = accRepo.findById(atm.getBank().getId());
		Account account = accOpt.get();
		/*
		 * if (accOp == null) { throw new BankException("Account not found "); }
		 */
		try {
			BigDecimal amounts = atm.getAmount().subtract(amount);
			atm.setAmount(amounts);
			atmRepo.save(atm);
			BigDecimal bankAmount = account.getAmount().subtract(amount);
			account.setAmount(bankAmount);
			accRepo.save(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("Can't withdraw");
		}
		return atm;
	}

}
