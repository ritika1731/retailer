package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RefMoney {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	

	@Id
	Integer denomination;

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
	 * @param denomination
	 */
	public RefMoney(Integer denomination) {
		super();
		this.denomination = denomination;
	}

	/**
	 * 
	 */
	public RefMoney() {
		super();
	}

	@Override
	public String toString() {
		return "RefMoney [denomination=" + denomination + "]";
	}
}
