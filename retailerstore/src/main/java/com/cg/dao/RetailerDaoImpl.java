package com.cg.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Supplier;

@Repository
public class RetailerDaoImpl implements RetailerDao{

	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
      
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	@Override
	public Goods retrieveGoods(int goodsId) {
//		Goods goods=entityManager.find(Goods.class, goodsId);
	return null;
	}

	@Override
	public Customer retrieveCustomer(int customerId) {
	//	Customer customer=entityManager.find(Customer.class, customerId);
		return null;
	}

	@Override
	public Supplier retrieveSupplier(int SupplierId) {
	//	Supplier supplier=entityManager.find(Supplier.class, SupplierId);
		return null;
	}

}
