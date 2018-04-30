package com.cg.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.cg.entity.Supplier;


public class SupplierDaoImpl implements SupplierDao {

	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
      
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
	@Override
	public Supplier addSupplier(Supplier supplier) {
//		entityManager.persist(supplier);
//		entityManager.flush();
//		
		return supplier;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
//		entityManager.merge(supplier);
//		entityManager.flush();
		return supplier;
	}

	@Override
	public boolean deleteSupplier(int supplierId) {
//		Supplier supplier=entityManager.find(Supplier.class, supplierId);
//		if(supplier!=null)
//			
//		{
//			entityManager.remove(supplier);
//			entityManager.flush();
//			return true;
//		}
		return false;
	}
	

}
