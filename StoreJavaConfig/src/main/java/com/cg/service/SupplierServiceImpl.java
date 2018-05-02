package com.cg.service;

import com.cg.dao.SupplierDao;
import com.cg.entity.Supplier;


public class SupplierServiceImpl implements SupplierService {

	
	SupplierDao dao;
	
	public SupplierServiceImpl(SupplierDao supplierDao) {
		dao=supplierDao;	
	}

	@Override
	public Supplier addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return dao.addSupplier(supplier);
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return dao.updateSupplier(supplier);
	}

	@Override
	public Supplier deleteSupplier(int supplierId) {
		// TODO Auto-generated method stub
		return dao.deleteSupplier(supplierId);
	}

}
