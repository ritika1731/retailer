package com.cg.retail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retail.entity.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Integer>{

}
