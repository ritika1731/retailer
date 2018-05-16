package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	 
	 @JoinColumn(name = "bankId")
	 private Integer bankId;
	 
	 private String name;
	 
	 private Integer pin;

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
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
	 * @param pin the pin to set
	 */
	public void setPin(Integer pin) {
		this.pin = pin;
	}

	/**
	 * @param customerId
	 * @param bankId
	 * @param name
	 * @param pin
	 */
	public Customer(Integer customerId, Integer bankId, String name, Integer pin) {
		super();
		this.customerId = customerId;
		this.bankId = bankId;
		this.name = name;
		this.pin = pin;
	}

	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", bankId=" + bankId + ", name=" + name + ", pin=" + pin + "]";
	}
	 
	 
	
}
