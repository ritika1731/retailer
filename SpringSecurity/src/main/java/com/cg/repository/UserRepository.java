package com.cg.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.User;

public interface UserRepository extends JpaRepository<User, Serializable> {

	
	Optional<User> findByUserName(String userName);
}
