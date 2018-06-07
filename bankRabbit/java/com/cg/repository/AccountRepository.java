package com.cg.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<Account> findByAccountId(Integer accountId);
}
