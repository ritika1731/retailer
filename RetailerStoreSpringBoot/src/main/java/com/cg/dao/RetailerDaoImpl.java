package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;

@Repository
public class RetailerDaoImpl  implements RetailerDao{
	@PersistenceContext
	private EntityManager entityManager;

	 @Override
		public Retailer addRetailer(Retailer retailer) {
			entityManager.persist(retailer);
			entityManager.flush();
	        return retailer;
		}
	@Override
	public List<Goods> retrieveGoods() {
		String query = "SELECT g FROM Goods g";
		TypedQuery<Goods> typedQuery = entityManager.createQuery(query, Goods.class);
		return typedQuery.getResultList();
	}

	
	
	@Override
	public List<Customer> retrieveCustomer() {
		String query = "SELECT c FROM Customer c";
		TypedQuery<Customer> typedQuery = entityManager.createQuery(query, Customer.class);
		return typedQuery.getResultList();
	}

	@Override
	public List<Supplier> retrieveSupplier() {
		String query = "SELECT s FROM Supplier s";
		TypedQuery<Supplier> typedQuery = entityManager.createQuery(query, Supplier.class);
		return typedQuery.getResultList();
		
	}


	

}
