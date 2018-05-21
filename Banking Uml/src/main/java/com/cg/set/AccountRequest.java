package com.cg.set;

import com.cg.entity.Account;

public class AccountRequest {

	private Integer bankId;
	private Integer customerId;
	private Account account;

	/**
	 * @return the bankId
	 */
	public Integer getBankId() {
		return bankId;
	}

	/**
	 * @param bankId
	 *            the bankId to set
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @param bankId
	 * @param customerId
	 * @param account
	 */
	public AccountRequest(Integer bankId, Integer customerId, Account account) {
		super();
		this.bankId = bankId;
		this.customerId = customerId;
		this.account = account;
	}

}
