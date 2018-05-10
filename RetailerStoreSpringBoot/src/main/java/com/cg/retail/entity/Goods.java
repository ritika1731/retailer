/**
 * 
 */
package com.cg.retail.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author RITIKA
 *
 */

@Entity
public class Goods {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int goodsId;
	private String goodsName;
	private int goodsQuantity;
	private double goodsPrice;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsQuantity() {
		return goodsQuantity;
	}
	public void setGoodsQuantity(int goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * @param goodsId
	 * @param goodsName
	 * @param goodsQuantity
	 * @param goodsPrice
	 */
	public Goods( String goodsName, int goodsQuantity, double goodsPrice) {
		super();
		this.goodsName = goodsName;
		this.goodsQuantity = goodsQuantity;
		this.goodsPrice = goodsPrice;
	}
	/**
	 * 
	 */
	
	public Goods() {
		super();
	}
	public Goods(int goodsId) {
		super();
		this.goodsId = goodsId;
	}




}
