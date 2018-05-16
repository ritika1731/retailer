package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Integer> {

}
