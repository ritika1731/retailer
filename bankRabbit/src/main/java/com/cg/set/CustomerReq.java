package com.cg.set;

import com.cg.entity.Customer;

public class CustomerReq {

	Integer bankId;
	Customer customer;
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
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @param bankId
	 * @param customer
	 */
	public CustomerReq(Integer bankId, Customer customer) {
		super();
		this.bankId = bankId;
		this.customer = customer;
	}
	/**
	 * 
	 */
	public CustomerReq() {
		super();
	}
	
	
	
}
