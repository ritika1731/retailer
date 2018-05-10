package com.cg.retail.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="supplierId")
	private Integer supplierId;
	@Column(name="supplierName")
	private String supplierName;
	@Column(name="supplierAddress")
	private String supplierAddress;
	@Column(name="quantityOrder")
	private Integer quantityOrder;
	@Column(name="orderId")
	private Integer orderId;
	@Column(name="amount")
	private double amount;
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public Integer getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @param supplierId
	 * @param supplierName
	 * @param supplierAddress
	 * @param quantityOrder
	 * @param orderId
	 * @param amount
	 */
	public Supplier( String supplierName, String supplierAddress, Integer quantityOrder, Integer orderId,
			double amount) {
		super();
		
		this.supplierName = supplierName;
		this.supplierAddress = supplierAddress;
		this.quantityOrder = quantityOrder;
		this.orderId = orderId;
		this.amount = amount;
	}
	
	
	public Supplier(Integer supplierId) {
		super();
		this.supplierId = supplierId;
	}
	/**
	 * 
	 */
	public Supplier() {
		super();
	}

}
