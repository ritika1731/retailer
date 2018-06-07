package com.cg.services;

import java.math.BigDecimal;

import com.cg.entity.Account;
import com.cg.set.AccountRequest;

public interface AccountService {

	public Account createAccount(AccountRequest acctReq);

	public Object getAccountDetailsById(Account account);

	public Account depositMoney(Integer accountId, BigDecimal amount);

	public Account withdraw(Integer accountId, BigDecimal amount,String select,Integer atmId);
}
