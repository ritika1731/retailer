package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	private String name;

	private Integer pin;
	@ManyToOne
	private Bank bank;

	/**
	 * @param customerId
	 * @param bankId
	 * @param name
	 * @param pin
	 * @param account
	 */
	public Customer(String name, Integer pin, Bank bank) {
		super();

		this.name = name;
		this.pin = pin;
		this.bank = bank;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pin
	 */
	public Integer getPin() {
		return pin;
	}

	/**
	 * @param pin
	 *            the pin to set
	 */
	public void setPin(Integer pin) {
		this.pin = pin;
	}

	/**
	 * @return the account
	 */

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", pin=" + pin + ", bank=" + bank + "]";
	}

	/**
	 * @param bank
	 *            the bank to set
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	/**
	 * @return the bank
	 */
	public Bank getBank() {
		return bank;
	}

}
