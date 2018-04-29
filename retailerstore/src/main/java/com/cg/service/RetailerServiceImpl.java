package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.RetailerDao;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Supplier;


@Service
@Transactional
public class RetailerServiceImpl implements RetailerService{

	@Autowired
	RetailerDao dao;
	
	@Override
	public Goods retrieveGoods(int goodsId) {
		// TODO Auto-generated method stub
		return dao.retrieveGoods(goodsId);
	}

	@Override
	public Customer retrieveCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.retrieveCustomer(customerId);
	}

	@Override
	public Supplier retrieveSupplier(int SupplierId) {
		// TODO Auto-generated method stub
		return dao.retrieveSupplier(SupplierId);
	}

}
