package com.cg.services;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.controller.CustomerController;
import com.cg.entity.ATM;
import com.cg.entity.Account;
import com.cg.entity.Bank;
import com.cg.entity.Customer;
import com.cg.exception.BankException;
import com.cg.repository.ATMRepository;
import com.cg.repository.AccountRepository;
import com.cg.repository.BankRepository;
import com.cg.repository.CustomerRepository;
import com.cg.set.AccountRequest;

@Service
public class AccountServiceImpl implements AccountService {
	private final static Logger LOGGER = Logger.getLogger(AccountService.class.getName());

	@Autowired
	AccountRepository accRepo;
	@Autowired
	BankRepository bankRepo;
	@Autowired
	ATMRepository atmRepo;
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	TransactionService transactionService;
	@Autowired
	BankDenominationService bankdenoSer;

	public Account createAccount(AccountRequest acctReq) {

		Optional<Bank> bankOpt = bankRepo.findById(acctReq.getBankId());
		// Bank bank = bankOpt.get();

		Optional<Customer> custOpt = custRepo.findBycustomerId(acctReq.getCustomerId());

		if (bankOpt.isPresent() && custOpt.isPresent()) {
			Bank bank = bankOpt.get();
			Customer customer = custOpt.get();
			Account account = acctReq.getAccount();
			account.setCustomer(customer);
			account.setBank(bank);
			BigDecimal amountBank = account.getAmount();
			bank.setAmount(bank.getAmount().add(amountBank));
			bankRepo.save(bank);
			return accRepo.save(account);
		} else {
			throw new BankException("bank or cust id doesn't exist");
		}

	}

	public Object getAccountDetailsById(@RequestBody Account account) {

		try {
			Object acc = accRepo.findByAccountId(account.getAccountId());
			return acc;
		} catch (BankException e) {
			// TODO Auto-generated catch block
			throw new BankException("Id not found");
		}
	}

	@Override
	public Account depositMoney(Integer accountId, BigDecimal amount) {
		Optional<Account> accOp = accRepo.findByAccountId(accountId);
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
			transactionService.createTransaction(account, "Credit");
			System.out.println("in");
			bankdenoSer.addDemomination(bank, amount);
			System.out.println("still in");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BankException("deposit failed");
		}
		return account;
	}

	@Override
	@Transactional
	public Account withdraw(Integer accountId, BigDecimal amount, String select, Integer atmId) {
		Optional<Account> accOp = accRepo.findByAccountId(accountId);
		Account account = accOp.get();

		Optional<Bank> bankOpt = bankRepo.findById(account.getCustomer().getBank().getId());
		Bank bank = bankOpt.get();

		if (select.equals("bank")) {
			BigDecimal amounts = account.getAmount().subtract(amount);
			account.setAmount(amounts);
			accRepo.save(account);

			BigDecimal bankAmount = bank.getAmount().subtract(amount);
			bank.setAmount(bankAmount);
			bankRepo.save(bank);
			transactionService.createTransaction(account, "debit");
			bankdenoSer.addDemomination(bank, amount);

		} else if (select.equals("atm")) {
			Optional<ATM> atmOp = atmRepo.findByAtmId(atmId);
			ATM atm = atmOp.get();

			BigDecimal amounts = atm.getAmount().subtract(amount);
			atm.setAmount(amounts);
			atmRepo.save(atm);
			BigDecimal accamount = account.getAmount().subtract(amount);
			account.setAmount(accamount);
			accRepo.save(account);

			transactionService.createTransaction(account, "debit");
			bankdenoSer.addDemomination(bank, amount);

		} else {
			throw new BankException("bank or atm");
		}
		return account;
	}

}
