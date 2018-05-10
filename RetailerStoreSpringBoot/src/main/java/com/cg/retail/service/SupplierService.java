package com.cg.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.SupplierDao;
import com.cg.retail.entity.Supplier;

@Service
public class SupplierService {

	@Autowired
	private SupplierDao supplierDao;
	
	
	public Supplier addSupplier(@RequestBody Supplier supplier) {
		return supplierDao.save(supplier);

	}

	public Supplier updateSupplier(@RequestBody Integer supplierId) {
		Supplier customer = supplierDao.getOne(supplierId);
		customer.setSupplierAddress("Noida");
		return supplierDao.save(customer);

	}

	public Supplier deleteSupplier(@RequestBody Integer supplierId) {
		Supplier supplier = new Supplier(supplierId);
		supplierDao.deleteById(supplierId);
		return supplier;

	}

	public List<Supplier> getSupplier() {
		return supplierDao.findAll();
	}

	public Object viewbyId(@RequestBody Supplier supplier) {
		System.out.println(supplier.getSupplierId());

		Object cust = supplierDao.findById(supplier.getSupplierId());
		System.out.println(cust);
		return cust;
	}
}
