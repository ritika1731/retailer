package com.cg.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.cg.entity.Retailer;


public class RetailerDaoImpl extends JdbcDaoSupport implements RetailerDao{

	@Override
	public String retrieveGoods(int goodsId) {
		 String query = "select * from goods where goodsId=?"; 
	        Object[] inputs = new Object[] {goodsId};
	        String goods = getJdbcTemplate().queryForObject(query, inputs, String.class);
			return goods;
	        
	}

	
	@Override
	public String retrieveCustomer(int customerId) {
		 String query = "select * from customer where customerId=?"; 
	        Object[] inputs = new Object[] {customerId};
	        String cust = getJdbcTemplate().queryForObject(query, inputs, String.class);
	        return cust;
	}

	@Override
	public String retrieveSupplier(int supplierId) {
		 String query = "select * from supplier where supplierId=?"; 
	        Object[] inputs = new Object[] {supplierId};
	        String supplier = getJdbcTemplate().queryForObject(query, inputs, String.class);
	        return supplier;
	}


	@Override
	public Retailer addRetailer(Retailer retailer) {
		String query = "insert into retailer (retailerId,retailerName,retailerAddress,customerId,supplierId,goodsId) values (?,?,?,?)";
        DataSource dataSource = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Object[] inputs = new Object[] {retailer.getRetailerId(), retailer.getRetailerName(), retailer.getRetailerAddress()};
        jdbcTemplate.update(query, inputs);
        return retailer;
	}

}
