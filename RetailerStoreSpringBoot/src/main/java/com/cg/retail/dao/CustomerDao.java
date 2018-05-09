package com.cg.retail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retail.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	
}
