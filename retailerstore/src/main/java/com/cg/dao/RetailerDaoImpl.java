package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Supplier;

@Repository
public class RetailerDaoImpl implements RetailerDao{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public Goods retrieveGoods(int goodsId) {
		Goods goods=entityManager.find(Goods.class, goodsId);
		return goods;
	}

	@Override
	public Customer retrieveCustomer(int customerId) {
		Customer customer=entityManager.find(Customer.class, customerId);
		return customer;
	}

	@Override
	public Supplier retrieveSupplier(int SupplierId) {
		Supplier supplier=entityManager.find(Supplier.class, SupplierId);
		return supplier;
	}

}
