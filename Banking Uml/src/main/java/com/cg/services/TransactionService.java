package com.cg.services;

import com.cg.entity.Customer;
import com.cg.entity.Transaction;
import com.cg.set.TransactionRequest;

public interface TransactionService {

	public Transaction createAccount(TransactionRequest transacReq);

	public Object generateTrasactionReport(Customer customer);

}
