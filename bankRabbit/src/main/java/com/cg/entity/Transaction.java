package com.cg.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transcationId;
	private BigDecimal amount;
	private String transactionType;
	@ManyToOne
	private Account account;
	@ManyToOne
	private Customer customer;

	/**
	 * @return the transcationId
	 */
	public Integer getTranscationId() {
		return transcationId;
	}

	/**
	 * @param transcationId
	 *            the transcationId to set
	 */
	public void setTranscationId(Integer transcationId) {
		this.transcationId = transcationId;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType
	 *            the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @param transcationId
	 * @param customerId
	 * @param accountId
	 * @param amount
	 * @param transactionType
	 */
	public Transaction(BigDecimal amount, String transactionType, Account account, Customer customer) {
		super();

		this.amount = amount;
		this.transactionType = transactionType;
		this.account = account;
		this.customer = customer;
	}

	/**
	 * 
	 */
	public Transaction() {
		super();
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
