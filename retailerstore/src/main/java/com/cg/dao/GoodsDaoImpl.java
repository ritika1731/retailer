package com.cg.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cg.entity.Goods;

@Repository
public class GoodsDaoImpl implements GoodsDao{

	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
      
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	public Goods addGoods(Goods goods) {
		 String query = "insert into goods (goodsId,goodsName,goodsQuantity,goodsPrice) values (?,?,?,?)";
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        Object[] inputs = new Object[] {goods.getGoodsId(), goods.getGoodsName(), goods.getGoodsQuantity(),goods.getGoodsPrice()};
	        jdbcTemplate.update(query, inputs);
	        return goods;
	}

	@Override
	public Goods updateGoods(Goods goods) {
		/*entityManager.merge(goods);
		entityManager.flush();
		return goods;*/return goods;
	}

	@Override
	public boolean deleteGoods(int goodsId) {
		/*Goods goods=entityManager.find(Goods.class, goodsId);
		if(goods!=null)
			
		{
			entityManager.remove(goods);
			entityManager.flush();
			return true;
		}
		return false;*/return false;
	
	}

	@Override
	public Goods orderGoods(Goods goods) {
		// TODO Auto-generated method stub
		return null;
	}

}
