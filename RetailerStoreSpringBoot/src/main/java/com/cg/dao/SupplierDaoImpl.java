package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {
@PersistenceContext
private EntityManager entityManager;
	
	@Override
	public Supplier addSupplier(Supplier supplier) {
		entityManager.persist(supplier);
		entityManager.flush();
        return supplier;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		entityManager.merge(supplier);
		entityManager.flush();
		return supplier;
	}

	@Override
	public Supplier deleteSupplier(int supplierId) {
		Supplier supplier=entityManager.find(Supplier.class,supplierId);
		return supplier;
	}

	

}
