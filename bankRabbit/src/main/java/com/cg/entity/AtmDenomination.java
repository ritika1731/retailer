package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class AtmDenomination {

	@OneToOne(targetEntity = ATM.class)
	private ATM atm;
	private Integer noOfDenomination;
	@Id
	private Integer denomination;

	/*
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
	 * @return the noOfDenomination
	 */
	public Integer getNoOfDenomination() {
		return noOfDenomination;
	}

	/**
	 * @param noOfDenomination
	 *            the noOfDenomination to set
	 */
	public void setNoOfDenomination( Integer noOfDenomination) {
		this.noOfDenomination = noOfDenomination;
	}

	/**
	 * @return the denomination
	 */
	public Integer getDenomination() {
		return denomination;
	}

	/**
	 * @param denomination
	 *            the denomination to set
	 */
	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}

	/**
	 * @param atm
	 * @param noOfDenomination
	 * @param denomination
	 */
	public AtmDenomination(ATM atm, Integer noOfDenomination, Integer denomination) {
		super();
		this.atm = atm;
		this.noOfDenomination = noOfDenomination;
		this.denomination = denomination;
	}

	/**
	 * 
	 */
	public AtmDenomination() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AtmDenomination [atm=" + atm + ", noOfDenomination=" + noOfDenomination + ", denomination="
				+ denomination + "]";
	}

}
