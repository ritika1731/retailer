package com.cg.services;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.exception.BankException;
import com.cg.repository.AccountRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.TransactionRepository;
import com.cg.set.TransactionRequest;

@Service
public class TransactionServiceImpl implements TransactionService {
	private final static Logger LOGGER = Logger.getLogger(TransactionService.class.getName());

	@Autowired
	CustomerRepository custRepo;
	@Autowired
	AccountRepository accRepo;
	@Autowired
	TransactionRepository transacRepo;
	@Override
	public Transaction createAccount(TransactionRequest transacReq) {
		Optional<Customer> custOpt = custRepo.findById(transacReq.getCustomerId());
		Customer customer = custOpt.get();
		Optional<Account> accOpt = accRepo.findById(transacReq.getAccountId());
		Account account = accOpt.get();
		Transaction transaction = transacReq.getTransaction();
		transaction.setCustomer(customer);
		transaction.setAccount(account);
		return transacRepo.save(transaction);

	}

	@Override
	public Object generateTrasactionReport(Customer customer) {
		try {
			Object cust = custRepo.findById(customer.getCustomerId());
			return cust;
		} catch (BankException e) {
			// TODO Auto-generated catch block
			throw new BankException("Id not found");
		}
	}

}
