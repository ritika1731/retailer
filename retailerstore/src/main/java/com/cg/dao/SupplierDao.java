package com.cg.dao;

import com.cg.entity.Supplier;

public interface SupplierDao {
	
	public Supplier addSupplier(Supplier supplier);
	
	public Supplier updateSupplier(Supplier supplier);

	public Supplier deleteSupplier(int supplierId);
}
