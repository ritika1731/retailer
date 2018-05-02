package com.cg.service;

import com.cg.dao.RetailerDao;



public class RetailerServiceImpl implements RetailerService{


	RetailerDao dao;
	
	public RetailerServiceImpl(RetailerDao retailerDao) {
	dao=retailerDao;
	}

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
