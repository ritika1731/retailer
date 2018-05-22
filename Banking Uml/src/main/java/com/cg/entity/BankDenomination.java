package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankDenomination {

	


	@OneToOne(targetEntity = Bank.class)
	private Bank bank;
	private Integer noOfDenomination;
	@Id
	private Integer denomination;

	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}
	/**
	 * @param bank the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	/**
	 * @return the noOfDenomination
	 */
	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}
	/**
	 * @param noOfDenomination the noOfDenomination to set
	 */
	public void setNoOfDenomination(Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
	}
	/**
	 * @return the denomination
	 */
	public Integer getDenomination() {
		return denomination;
	}
	/**
	 * @param randomElement the denomination to set
	 */
	public void setDenomination(Integer randomElement) {
		this.denomination = randomElement;
	}
	/**
	 * @param bank
	 * @param noOfDenomination
	 * @param denomination
	 */
	public BankDenomination(Bank bank, Integer noOfDenomination, Integer denomination) {
		super();
		this.bank = bank;
		this.noOfDenomination = noOfDenomination;
		this.denomination = denomination;
	}

	/**
	 * 
	 */
	public BankDenomination() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankDenomination [ bank=" + bank + ", noOfDenomination="
				+ noOfDenomination + ", denomination=" + denomination + "]";
	}



}
