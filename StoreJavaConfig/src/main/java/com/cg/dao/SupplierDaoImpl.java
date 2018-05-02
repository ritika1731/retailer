package com.cg.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cg.entity.Supplier;


public class SupplierDaoImpl implements SupplierDao {

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated method stub
		this.jdbcTemplate=jdbcTemplate;
	}
	
	@Override
	public Supplier addSupplier(Supplier supplier) {
		String query = "insert into supplier (supplierId,supplierName,supplierAddress,quantityOrder,orderId,amount) values (?,?,?,?,?,?)";
        Object[] inputs = new Object[] {supplier.getSupplierId(), supplier.getSupplierName(), supplier.getSupplierAddress(),supplier.getQuantityOrder(),supplier.getOrderId(),supplier.getAmount()};
        jdbcTemplate.update(query, inputs);
        
		return supplier;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		String sql = "update supplier set amount=? where supplierId = ?";
        Object[] inputs = new Object[] {supplier.getAmount(),supplier.getSupplierId()};
       jdbcTemplate.update(sql, inputs);
		return supplier;
	}

	@Override
	public Supplier deleteSupplier(int supplierId) {
		String sql = "delete from supplier where supplierId = ?";
        jdbcTemplate.update(sql,new Object[]{supplierId});
		return null;
	}

	

}
