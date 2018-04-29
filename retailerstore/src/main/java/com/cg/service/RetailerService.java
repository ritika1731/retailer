package com.cg.service;

import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Supplier;

public interface RetailerService {

	public Goods retrieveGoods(int goodsId);

	public Customer retrieveCustomer(int customerId);

	public Supplier retrieveSupplier(int SupplierId);
}
