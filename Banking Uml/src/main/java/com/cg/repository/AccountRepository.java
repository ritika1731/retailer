package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
