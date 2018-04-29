package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.entity.Goods;

@Repository
public class GoodsDaoImpl implements GoodsDao{

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public Goods addGoods(Goods goods) {
		entityManager.persist(goods);
		entityManager.flush();	//required to reflect changes on database
		
		return goods;
	}

	@Override
	public Goods updateGoods(Goods goods) {
		entityManager.merge(goods);
		entityManager.flush();
		return goods;
	}

	@Override
	public boolean deleteGoods(int goodsId) {
		Goods goods=entityManager.find(Goods.class, goodsId);
		if(goods!=null)
			
		{
			entityManager.remove(goods);
			entityManager.flush();
			return true;
		}
		return false;
	
	}

	@Override
	public Goods orderGoods(Goods goods) {
		// TODO Auto-generated method stub
		return null;
	}

}
