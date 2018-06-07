package com.cg.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ATM {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer atmId;
	private BigDecimal amount;
	@ManyToOne
	private Bank bank;

	/**
	 * @return the atmId
	 */
	public Integer getAtmId() {
		return atmId;
	}

	/**
	 * @param atmId
	 *            the atmId to set
	 */
	public void setAtmId(Integer atmId) {
		this.atmId = atmId;
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

	/**
	 * @param aTMId
	 * @param amount
	 * @param bankId
	 */
	public ATM(BigDecimal amount, Bank bank) {
		super();

		this.amount = amount;
		this.bank = bank;

	}

	/**
	 * 
	 */
	public ATM() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ATM [atmId=" + atmId + ", amount=" + amount + "]";
	}

	/**
	 * @param bank
	 *            the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
