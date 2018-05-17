package com.cg.set;

import com.cg.entity.Transaction;

public class TransactionRequest {

	private Integer customerId;
	private Integer accountId;
	private Transaction transaction;

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
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the transaction
	 */
	public Transaction getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction
	 *            the transaction to set
	 */
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
