package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

	Optional<Bank> findById(Integer id);

}
