package com.cg.service;

import com.cg.dao.GoodsDao;
import com.cg.entity.Goods;


public class GoodsServiceImpl implements GoodsService{

	GoodsDao dao;
	
	
	public GoodsServiceImpl(GoodsDao goodsDao) {
	dao=goodsDao;
	}

	@Override
	public Goods addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.addGoods(goods);
	}

	@Override
	public Goods updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.updateGoods(goods);
	}

	@Override
	public int deleteGoods(int goodsId) {
		// TODO Auto-generated method stub
		return dao.deleteGoods(goodsId);
	}

	@Override
	public Goods orderGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.orderGoods(goods);
	}

}
