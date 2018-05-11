package com.cg.retail.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.SupplierDao;
import com.cg.retail.entity.Supplier;
import com.cg.retail.exception.StoreException;

@Service
public class SupplierService {
	private final static Logger LOGGER = Logger.getLogger(SupplierService.class.getName());

	@Autowired
	private SupplierDao supplierDao;
	
	
	public Supplier addSupplier(@RequestBody Supplier supplier) {
		return supplierDao.save(supplier);

	}

	public Supplier updateSupplier(@RequestBody Integer supplierId) {
		try {
			Supplier customer = supplierDao.getOne(supplierId);
			customer.setSupplierAddress("Noida");
			return supplierDao.save(customer);
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			throw new StoreException("Id not found");
		}

	}

	public Supplier deleteSupplier(@RequestBody Integer supplierId) {
		try {
			Supplier supplier = new Supplier(supplierId);
			supplierDao.deleteById(supplierId);
			return supplier;
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			throw new StoreException("Id not found");
		}

	}

	public List<Supplier> getSupplier() {
		return supplierDao.findAll();
	}

	public Object viewbyId(@RequestBody Supplier supplier) {
		LOGGER.info(supplier.getSupplierId());

		Object cust = supplierDao.findById(supplier.getSupplierId());
		System.out.println(cust);
		return cust;
	}
}
