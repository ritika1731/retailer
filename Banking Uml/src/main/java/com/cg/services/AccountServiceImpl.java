package com.cg.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Account;
import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.exception.BankException;
import com.cg.repository.AccountRepository;
import com.cg.repository.BankRepository;
import com.cg.repository.CustomerRepository;
import com.cg.set.AccountRequest;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accRepo;
	@Autowired
	BankRepository bankRepo;

	@Autowired
	CustomerRepository custRepo;

	public Account createAccount(AccountRequest acctReq) {

		Optional<Bank> bankOpt = bankRepo.findById(acctReq.getBankId());
		Bank bank = bankOpt.get();

		Optional<Customer> custOpt = custRepo.findById(acctReq.getCustomerId());
		Customer customer = custOpt.get();
		Account account = acctReq.getAccount();
		account.setCustomer(customer);
		account.setBank(bank);

		BigDecimal amountBank = account.getAmount();
		bank.setAmount(bank.getAmount().add(amountBank));
		bankRepo.save(bank);

		return accRepo.save(account);
	}

	public Object getAccountDetailsById(@RequestBody Account account) {

		try {
			Object acc = accRepo.findById(account.getAccountId());
			return acc;
		} catch (BankException e) {
			// TODO Auto-generated catch block
			throw new BankException("Id not found");
		}
	}

	@Override
	public Account depositMoney(Integer accountId, BigDecimal amount) {
		Optional<Account> accOp = accRepo.findById(accountId);
		Account account = accOp.get();

		Optional<Bank> bankOpt = bankRepo.findById(account.getCustomer().getBank().getId());
		Bank bank = bankOpt.get();
		/*
		 * if (accOp == null) { throw new BankException("Account not found "); }
		 */

		try {
			BigDecimal amounts = account.getAmount().add(amount);
			account.setAmount(amounts);
			accRepo.save(account);

			BigDecimal bankAmount = bank.getAmount().add(amount);
			bank.setAmount(bankAmount);
			bankRepo.save(bank);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("deposit failed");
		}
		return account;
	}

	@Override
	public Account withdraw(Integer accountId, BigDecimal amount) {
		Optional<Account> accOp = accRepo.findById(accountId);
		Account account = accOp.get();

		Optional<Bank> bankOpt = bankRepo.findById(account.getCustomer().getBank().getId());
		Bank bank = bankOpt.get();

		try {
			BigDecimal amounts = account.getAmount().subtract(amount);
			account.setAmount(amounts);
			accRepo.save(account);

			BigDecimal bankAmount = bank.getAmount().subtract(amount);
			bank.setAmount(bankAmount);
			bankRepo.save(bank);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("withdraw failed");
		}
		return account;
	}

}
