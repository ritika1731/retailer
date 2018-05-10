package com.cg.retail.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retail.entity.Goods;

public interface GoodsDao extends JpaRepository<Goods, Integer> {

}
