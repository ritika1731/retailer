package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.RetailerDao;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;


@Service

public class RetailerServiceImpl implements RetailerService{

@Autowired
	private RetailerDao dao;
	
	

	@Override
	public List<Goods> retrieveGoods() {
		// TODO Auto-generated method stub
		return dao.retrieveGoods();
	}

	@Override
	public List<Customer> retrieveCustomer() {
		// TODO Auto-generated method stub
		return dao.retrieveCustomer();
	}

	@Override
	public List<Supplier> retrieveSupplier() {
		// TODO Auto-generated method stub
		return dao.retrieveSupplier();
	}

	@Override
	public Retailer addRetailer(Retailer retailer) {
		// TODO Auto-generated method stub
		return dao.addRetailer(retailer);
	}

}
