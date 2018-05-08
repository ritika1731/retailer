package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		entityManager.flush();
	        return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {

		entityManager.merge(customer);
		entityManager.flush();
		return customer;
	}

	@Override
	public Customer deleteCustomer(int customerId) {
		
		Customer cust=entityManager.find(Customer.class,customerId);
			return cust;
		
		
	}
	
}
