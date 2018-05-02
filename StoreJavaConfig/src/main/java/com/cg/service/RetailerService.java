package com.cg.service;

import com.cg.entity.Retailer;

public interface RetailerService {

	public String retrieveGoods(int goodsId);

	public int retrieveCustomer(int customerId);

	public String retrieveSupplier(int SupplierId);
	public Retailer addRetailer(Retailer retailer);

}
