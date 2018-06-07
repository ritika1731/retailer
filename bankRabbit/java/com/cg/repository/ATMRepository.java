package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.ATM;

public interface ATMRepository extends JpaRepository<ATM, Integer> {
	
	Optional<ATM> findByAtmId(Integer atmId);
}
