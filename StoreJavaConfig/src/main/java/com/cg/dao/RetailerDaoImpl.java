package com.cg.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;


public class RetailerDaoImpl  implements RetailerDao{

	private JdbcTemplate jdbcTemplate;
	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
			this.jdbcTemplate=jdbcTemplate;
			
		}
	 @Override
		public Retailer addRetailer(Retailer retailer) {
			String query = "insert into retailer (retailerId,retailerName,retailerAddress) values (?,?,?)";
	        Object[] inputs = new Object[] {retailer.getRetailerId(), retailer.getRetailerName(), retailer.getRetailerAddress()};
	        jdbcTemplate.update(query, inputs);
	        return retailer;
		}
	@Override
	public List<Goods> retrieveGoods() {
		 /*String query = "select * from goods where goodsId=?"; 
	        Object[] inputs = new Object[] {goodsId};
	        String goods = jdbcTemplate.queryForObject(query, inputs, String.class);
			return goods;*/
		List<Goods> goodslist = jdbcTemplate
				.query("SELECT * from goods",new BeanPropertyRowMapper<Goods>(Goods.class));
		return goodslist; 
	}

	
	
	@Override
	public List<Customer> retrieveCustomer() {
		/* String query = "select * from customer where customerId=?"; 
	        Object[] inputs = new Object[] {customerId};
	        String cust = jdbcTemplate.queryForObject(query, inputs, String.class);
	        return 1;*/
		List<Customer> customerlist = jdbcTemplate.query("SELECT * from customer",new BeanPropertyRowMapper<Customer>(Customer.class));
		return customerlist;
	}

	@Override
	public List<Supplier> retrieveSupplier() {
		/* String query = "select * from supplier where supplierId=?"; 
	        Object[] inputs = new Object[] {supplierId};
	        String supplier = jdbcTemplate.queryForObject(query, inputs, String.class);
	        return supplier;*/

		List<Supplier> supplierlist = jdbcTemplate.query("SELECT * FROM supplier",new BeanPropertyRowMapper<Supplier>(Supplier.class));

		return supplierlist;
	}


	

}
