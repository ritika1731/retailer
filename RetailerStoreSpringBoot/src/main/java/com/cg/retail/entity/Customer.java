/**
 * 
 */
package com.cg.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author RITIKA
 *
 */
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="customerId")
	private Integer customerId;
	@Column(name="customerName",unique=true)
	//@UniqueElements
	private String customerName;
	@Column(name="customerAddress")
	private String customerAddress;
	@Column(name="paymentMode")

	private String paymentMode;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public Customer( String customerName, String customerAddress, String paymentMode) {
		super();
		
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.paymentMode = paymentMode;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(Integer customerId) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", paymentMode=" + paymentMode + "]";
	}
	
	
	
	
}
