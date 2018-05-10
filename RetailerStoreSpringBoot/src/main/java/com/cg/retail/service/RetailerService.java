package com.cg.retail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.RetailerDao;
import com.cg.retail.entity.Retailer;
@Service
public class RetailerService {
	@Autowired
	RetailerDao retailDao;
	
	public Retailer addRetailer(@RequestBody Retailer retailer) {
		return retailDao.save(retailer);

	}
}
