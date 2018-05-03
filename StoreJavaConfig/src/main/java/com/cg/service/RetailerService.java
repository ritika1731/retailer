package com.cg.service;

import java.util.List;

import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;

public interface RetailerService {

	public List<Goods> retrieveGoods();

	public List<Customer> retrieveCustomer();

	public List<Supplier> retrieveSupplier();
	public Retailer addRetailer(Retailer retailer);

}
