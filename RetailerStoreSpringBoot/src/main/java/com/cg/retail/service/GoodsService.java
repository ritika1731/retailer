package com.cg.retail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.GoodsDao;
import com.cg.retail.entity.Goods;

@Service
public class GoodsService {

	@Autowired
	private GoodsDao goodDao;


	public Goods addGoods(@RequestBody Goods Goods) {
		return goodDao.save(Goods);

	}

	public Goods updateGoods(@RequestBody Integer GoodsId) {
		Goods Goods = goodDao.getOne(GoodsId);
		Goods.setGoodsQuantity(45);
		return goodDao.save(Goods);

	}

	public Goods deleteGoods(@RequestBody Integer GoodsId) {
		Goods Goods = new Goods(GoodsId);
		goodDao.deleteById(GoodsId);
		return Goods;

	}

	public List<Goods> getGoods() {
		return goodDao.findAll();
	}

	public Object viewbyId(@RequestBody Goods goods) {
		System.out.println(goods.getGoodsId());

		Object good = goodDao.findById(goods.getGoodsId());
		System.out.println(good);
		return good;
	}

	public void addFirstGoodsAutomatically(Goods goods) {

		goodDao.save(goods);
	}

}
