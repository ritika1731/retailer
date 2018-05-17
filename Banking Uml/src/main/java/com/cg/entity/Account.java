package com.cg.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accountId;
	@ManyToOne
	private Customer customer;
	private BigDecimal amount;
	@ManyToOne
	private Bank bank;

	/**
	 * @param customer
	 * @param ob1
	 */
	public Account(Customer customer, Bank bak1) {
		super();
		this.customer = customer;
		this.bank = bak1;
	}

	/**
	 * @param customer
	 * @param amount
	 * @param bank
	 */
	public Account(Customer customer, BigDecimal amount, Bank bank) {
		super();
		this.customer = customer;
		this.amount = amount;
		this.bank = bank;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + "]";
	}

	/**
	 * 
	 */
	public Account() {
		super();
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
	 * @param customer
	 *            the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param bank
	 *            the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
