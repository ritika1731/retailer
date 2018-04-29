package com.cg.dao;

import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Supplier;

public interface RetailerDao {

	public Goods retrieveGoods(int goodsId);

	public Customer retrieveCustomer(int customerId);

	public Supplier retrieveSupplier(int SupplierId);

}
