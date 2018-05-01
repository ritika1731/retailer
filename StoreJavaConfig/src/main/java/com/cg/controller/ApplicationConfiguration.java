package com.cg.controller;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.cg.dao.CustomerDao;
import com.cg.dao.CustomerDaoImpl;
import com.cg.dao.GoodsDao;
import com.cg.dao.GoodsDaoImpl;
import com.cg.dao.RetailerDao;
import com.cg.dao.RetailerDaoImpl;
import com.cg.dao.SupplierDao;
import com.cg.dao.SupplierDaoImpl;

@Configuration
public class ApplicationConfiguration {
	
	 @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        //MySQL database we are using
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/store");
	        dataSource.setUsername("root");
	        dataSource.setPassword("root");
	        return dataSource;
	    }
	 
	    @Bean
	    public JdbcTemplate jdbcTemplate() {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate();
	        jdbcTemplate.setDataSource(dataSource());
	        return jdbcTemplate;
	    }
	 

	@Bean(name="customerDao")
	public CustomerDao customer() {
//		return new CustomerDaoImpl();
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		customerDao.setJdbcTemplate(jdbcTemplate());
        return customerDao;
	}        
	@Bean(name="goodsDao")
	public GoodsDao goods() {
		return new GoodsDaoImpl();
	}     
	@Bean(name="supplierDao")
	public SupplierDao supplier() {
		return new SupplierDaoImpl();
	}       
//	@Bean(name="retailerDao")
//	public RetailerDao retailer() {
//		return new RetailerDaoImpl();
//	}
}
