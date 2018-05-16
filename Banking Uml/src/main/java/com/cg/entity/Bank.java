package com.cg.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	private BigDecimal amount;
	@OneToMany(targetEntity= Customer.class, mappedBy= "bankId",fetch=FetchType.EAGER)
	private Set<Customer> customer;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @param id
	 * @param amount
	 */
	public Bank(Integer id, BigDecimal amount) {
		super();
		Id = id;
		this.amount = amount;
	}
	/**
	 * Default Constructor
	 */
	public Bank() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bank [Id=" + Id + ", amount=" + amount + "]";
	}
	
	
	
	
}
