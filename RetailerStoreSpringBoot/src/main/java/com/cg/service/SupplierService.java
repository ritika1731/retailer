package com.cg.service;

import com.cg.entity.Supplier;

public interface SupplierService {

public Supplier addSupplier(Supplier supplier);
	
	public Supplier updateSupplier(Supplier supplier);

	public Supplier deleteSupplier(int supplierId);
}
