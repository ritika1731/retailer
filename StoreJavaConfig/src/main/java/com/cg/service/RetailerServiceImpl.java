package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.RetailerDao;


@Service
@Transactional
public class RetailerServiceImpl implements RetailerService{

	@Autowired
	RetailerDao dao;
	
	@Override
	public String retrieveGoods(int goodsId) {
		// TODO Auto-generated method stub
		return dao.retrieveGoods(goodsId);
	}

	@Override
	public String retrieveCustomer(int customerId) {
		// TODO Auto-generated method stub
		return dao.retrieveCustomer(customerId);
	}

	@Override
	public String retrieveSupplier(int SupplierId) {
		// TODO Auto-generated method stub
		return dao.retrieveSupplier(SupplierId);
	}

}
