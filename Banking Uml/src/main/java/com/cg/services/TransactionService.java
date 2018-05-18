package com.cg.services;

import java.util.List;

import com.cg.entity.Account;
import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.set.TransactionRequest;

public interface TransactionService {

	//public Transaction createTransaction(TransactionRequest transactionReq, String transacType);
	
	public Transaction createTransaction(Account account, String transacType);

	public List<Transaction> generateTrasactionReport();



}
