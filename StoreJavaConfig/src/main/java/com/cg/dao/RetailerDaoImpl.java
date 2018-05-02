package com.cg.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import com.cg.entity.Retailer;


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
	public String retrieveGoods(int goodsId) {
		 String query = "select * from goods where goodsId=?"; 
	        Object[] inputs = new Object[] {goodsId};
	        String goods = jdbcTemplate.queryForObject(query, inputs, String.class);
			return goods;
	        
	}

	
	
	@Override
	public int retrieveCustomer(int customerId) {
		 String query = "select * from customer where customerId=?"; 
	        Object[] inputs = new Object[] {customerId};
	        String cust = jdbcTemplate.queryForObject(query, inputs, String.class);
	        return 1;
	}

	@Override
	public String retrieveSupplier(int supplierId) {
		 String query = "select * from supplier where supplierId=?"; 
	        Object[] inputs = new Object[] {supplierId};
	        String supplier = jdbcTemplate.queryForObject(query, inputs, String.class);
	        return supplier;
	}


	

}
