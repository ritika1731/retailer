package com.cg.entity;

import javax.persistence.Entity;

@Entity
public class Retailer {

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
	/**
	 * @param retailerName
	 * @param retailerAddress
	 */
	public Retailer(String retailerName, String retailerAddress) {
		super();
		this.retailerName = retailerName;
		this.retailerAddress = retailerAddress;
	}
	/**
	 * 
	 */
	public Retailer() {
		super();
	}
	@Override
	public String toString() {
		return "Retailer [retailerName=" + retailerName + ", retailerAddress=" + retailerAddress + "]";
	}



}


	
