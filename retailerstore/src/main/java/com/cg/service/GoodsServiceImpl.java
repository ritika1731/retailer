package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.GoodsDao;
import com.cg.entity.Goods;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	GoodsDao dao;
	
	
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
	public boolean deleteGoods(int goodsId) {
		// TODO Auto-generated method stub
		return dao.deleteGoods(goodsId);
	}

	@Override
	public Goods orderGoods(Goods goods) {
		// TODO Auto-generated method stub
		return dao.orderGoods(goods);
	}

}
