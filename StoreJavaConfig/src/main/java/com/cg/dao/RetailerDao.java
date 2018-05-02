package com.cg.dao;

import com.cg.entity.Retailer;

public interface RetailerDao {

	public Retailer addRetailer(Retailer retailer);
	
	public String retrieveGoods(int goodsId);

	public int retrieveCustomer(int customerId);

	public String retrieveSupplier(int supplierId);

}
