package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {
@PersistenceContext
EntityManager entityManager;
	@Override
	public Supplier addSupplier(Supplier supplier) {
		entityManager.persist(supplier);
		entityManager.flush();	//required to reflect changes on database
		
		return supplier;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		entityManager.merge(supplier);
		entityManager.flush();
		return supplier;
	}

	@Override
	public boolean deleteSupplier(int supplierId) {
		Supplier supplier=entityManager.find(Supplier.class, supplierId);
		if(supplier!=null)
			
		{
			entityManager.remove(supplier);
			entityManager.flush();
			return true;
		}
		return false;
	}
	

}
