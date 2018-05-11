package com.cg.retail.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.RetailerDao;
import com.cg.retail.entity.Retailer;
@Service
public class RetailerService {
	
	private final static Logger LOGGER = Logger.getLogger(RetailerService.class.getName());

	
	@Autowired
	RetailerDao retailDao;
	
	public Retailer addRetailer(@RequestBody Retailer retailer) {
		return retailDao.save(retailer);
		

	}
}
