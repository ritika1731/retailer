package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findBycustomerId(Integer customerId);

}
