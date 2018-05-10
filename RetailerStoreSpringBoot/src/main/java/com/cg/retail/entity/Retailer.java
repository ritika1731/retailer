package com.cg.retail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Retailer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int retailerId;
	private String retailerName;
	private String retailerAddress;
	public String getRetailerName() {
		return retailerName;
	}
	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}
	public String getRetailerAddress() {
		return retailerAddress;
	}
	public void setRetailerAddress(String retailerAddress) {
		this.retailerAddress = retailerAddress;
	}
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	/**
	 * @param retailerName
	 * @param retailerAddress
	 */
	
	/**
	 * 
	 */
	public Retailer() {
		super();
	}
	public Retailer(int retailerId, String retailerName, String retailerAddress) {
		super();
		this.retailerId = retailerId;
		this.retailerName = retailerName;
		this.retailerAddress = retailerAddress;
	}
	


}


	
