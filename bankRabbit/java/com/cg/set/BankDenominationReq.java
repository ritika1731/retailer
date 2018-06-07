package com.cg.set;

import java.math.BigDecimal;

import com.cg.entity.BankDenomination;

public class BankDenominationReq {
	
	Integer bankId;
	BigDecimal amount;
	BankDenomination bankDenomination;
	/**
	 * @return the bankId
	 */
	public Integer getBankId() {
		return bankId;
	}
	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return the bankDenomination
	 */
	public BankDenomination getBankDenomination() {
		return bankDenomination;
	}
	/**
	 * @param bankDenomination the bankDenomination to set
	 */
	public void setBankDenomination(BankDenomination bankDenomination) {
		this.bankDenomination = bankDenomination;
	}
	/**
	 * @param bankId
	 * @param amount
	 * @param bankDenomination
	 */
	public BankDenominationReq(Integer bankId, BigDecimal amount, BankDenomination bankDenomination) {
		super();
		this.bankId = bankId;
		this.amount = amount;
		this.bankDenomination = bankDenomination;
	}

}
