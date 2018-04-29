package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@PersistenceContext
	EntityManager entityManager;

	
	//List<Customer> list=new ArrayList();


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
	public boolean deleteCustomer(int customerId) {
		Customer customer=entityManager.find(Customer.class, customerId);
		if(customer!=null)
			
		{
			entityManager.remove(customer);
			entityManager.flush();
			return true;
		}
		return false;
	
	}

}
