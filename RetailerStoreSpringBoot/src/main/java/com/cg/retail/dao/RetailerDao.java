package com.cg.retail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retail.entity.Retailer;

public interface RetailerDao extends JpaRepository<Retailer, Integer> {

}
