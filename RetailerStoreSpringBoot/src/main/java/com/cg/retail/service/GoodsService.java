package com.cg.retail.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.retail.dao.GoodsDao;
import com.cg.retail.entity.Goods;
import com.cg.retail.exception.StoreException;

@Service
public class GoodsService {
	private final static Logger LOGGER = Logger.getLogger(GoodsService.class.getName());

	@Autowired
	private GoodsDao goodDao;


	public Goods addGoods(@RequestBody Goods Goods) {
		return goodDao.save(Goods);

	}

	public Goods updateGoods(@RequestBody Integer GoodsId) {
		try {
			Goods Goods = goodDao.getOne(GoodsId);
			Goods.setGoodsQuantity(45);
			return goodDao.save(Goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new StoreException("Id not found");
		}

	}

	public Goods deleteGoods(@RequestBody Integer GoodsId) {
		try {
			Goods Goods = new Goods(GoodsId);
			goodDao.deleteById(GoodsId);
			return Goods;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new StoreException("Id not found");
		}

	}

	public List<Goods> getGoods() {
		return goodDao.findAll();
	}

	public Object viewbyId(@RequestBody Goods goods) {
		LOGGER.info(goods.getGoodsId());

		Object good = goodDao.findById(goods.getGoodsId());
		System.out.println(good);
		return good;
	}


}
