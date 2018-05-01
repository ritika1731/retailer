package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.SupplierDao;
import com.cg.entity.Supplier;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	SupplierDao dao;
	
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
