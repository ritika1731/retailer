package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Goods;

@Repository
public class GoodsDaoImpl implements GoodsDao{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Goods addGoods(Goods goods) {
		entityManager.persist(goods);
		entityManager.flush();
		return goods;
	}

	@Override
	public Goods updateGoods(Goods goods) {
		entityManager.merge(goods);
		entityManager.flush();
		return goods;
	}

	@Override
	public Goods deleteGoods(int goodsId) {
		Goods goods=entityManager.find(Goods.class,goodsId);
		return goods;

	}

	@Override
	public Goods orderGoods(Goods goods) {
		// TODO Auto-generated method stub
		return null;
	}



}
