package com.cg.dao;

import com.cg.entity.Goods;

public interface GoodsDao {

	public Goods addGoods(Goods goods);
	
	public Goods updateGoods(Goods goods);

	public boolean deleteGoods(int goodsId);
	
	public Goods orderGoods(Goods goods);

	
}
