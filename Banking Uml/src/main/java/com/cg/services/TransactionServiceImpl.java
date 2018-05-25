package com.cg.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.repository.AccountRepository;
import com.cg.repository.CustomerRepository;
import com.cg.repository.TransactionRepository;
import com.cg.set.TransactionRequest;

/**
 * @author trainee
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	private final static Logger LOGGER = Logger.getLogger(TransactionService.class.getName());

	@Autowired
	CustomerRepository custRepo;
	@Autowired
	AccountRepository accRepo;
	@Autowired
	TransactionRepository transacRepo;

	//@Override
	/*public Transaction createTransaction(TransactionRequest transacReq,String TransacType) {
		final Optional<Customer> custOpt = custRepo.findById(transacReq.getCustomerId());
		final Customer customer = custOpt.get();

		final Optional<Account> accOpt = accRepo.findById(transacReq.getAccount().getAccountId());
		final Account account1 = accOpt.get();
		Transaction transaction = transacReq.getTransaction();
		transaction.setCustomer(customer);
		transaction.setAccount(account1);
		transaction.setAmount(transacReq.getAccount().getAmount());
		transaction.setTransactionType(TransacType);

		return transacRepo.save(transaction);

	}
*/
	@Override
	public List<Transaction> generateTrasactionReport() {
		return transacRepo.findAll();
	}

	@Override
	@Transactional
	public Transaction createTransaction(Account account, String transacType) {
		final Optional<Customer> custOpt = custRepo.findBycustomerId(account.getCustomer().getCustomerId());
		final Customer customer = custOpt.get();

		final Optional<Account> accOpt = accRepo.findByAccountId(account.getAccountId());
		final Account account1 = accOpt.get();
		Transaction transaction =new Transaction();
		transaction.setAccount(account1);
		transaction.setCustomer(customer);
		transaction.setAmount(account.getAmount());
		transaction.setTransactionType(transacType);
		return transacRepo.save(transaction);
	}

}
