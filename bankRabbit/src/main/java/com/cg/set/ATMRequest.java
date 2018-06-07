package com.cg.set;

import com.cg.entity.ATM;

public class ATMRequest {

	private ATM atm;
	private Integer bankId;
	private Integer accountId;

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
	 * @return the atm
	 */
	public ATM getAtm() {
		return atm;
	}

	/**
	 * @param atm
	 *            the atm to set
	 */
	public void setAtm(ATM atm) {
		this.atm = atm;
	}

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
	 * @param atm
	 * @param bankId
	 * @param accountId
	 */
	public ATMRequest(ATM atm, Integer bankId) {
		super();
		this.atm = atm;
		this.bankId = bankId;
	
	}

	
}
