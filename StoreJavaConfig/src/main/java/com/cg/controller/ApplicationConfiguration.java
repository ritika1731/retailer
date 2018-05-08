package com.cg.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
import com.cg.service.CustomerService;
import com.cg.service.CustomerServiceImpl;
import com.cg.service.GoodsService;
import com.cg.service.GoodsServiceImpl;
import com.cg.service.RetailerService;
import com.cg.service.RetailerServiceImpl;
import com.cg.service.SupplierService;
import com.cg.service.SupplierServiceImpl;

@Configuration
//@ComponentScan(basePackages="com.cg")
@PropertySource(value= {"classpath:application.properties"})
public class ApplicationConfiguration {
	 @Autowired
	    private Environment environment;
	@Bean(name="dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MySQL database we are using
		/*dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/store");
		dataSource.setUsername("root");
		dataSource.setPassword("root");*/
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName") );
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	@Bean(name="jdbcTemplate")
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean(name = "customerService")
	public CustomerService getCustomerService(CustomerDao customerDao)
	{
		CustomerServiceImpl service =  new CustomerServiceImpl(customerDao);

		return service;
	}

	@Bean(name="customerDao")
	public CustomerDao customerDao() {
		//return new CustomerDaoImpl();
		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		customerDao.setJdbcTemplate(jdbcTemplate());
		return customerDao;

	}       
	@Bean(name = "goodsService")
	public GoodsService getGoodsService(GoodsDao goodsDao)
	{
		GoodsServiceImpl service =  new GoodsServiceImpl(goodsDao);

		return service;
	}
	@Bean(name="goodsDao")
	public GoodsDao goodsDao() {
		//return new GoodsDaoImpl();
		GoodsDaoImpl goodsDao = new GoodsDaoImpl();
		goodsDao.setJdbcTemplate(jdbcTemplate());
		return goodsDao;
	}   

	@Bean(name = "supplierService")
	public SupplierService getSupplierService(SupplierDao supplierDao)
	{
		SupplierServiceImpl service =  new SupplierServiceImpl(supplierDao);

		return service;
	}

	@Bean(name="supplierDao")
	public SupplierDao supplierDao() {
		//return new SupplierDaoImpl();
		SupplierDaoImpl supplierDao = new SupplierDaoImpl();
		supplierDao.setJdbcTemplate(jdbcTemplate());
		return supplierDao;
	}   

	@Bean(name = "retailerService")
	public RetailerService getRetailerService(RetailerDao retailerDao)
	{
		RetailerServiceImpl service =  new RetailerServiceImpl(retailerDao);

		return service;
	}

	@Bean(name="retailerDao")
	public RetailerDao retailerDao() {
		//return new RetailerDaoImpl();
		RetailerDaoImpl retailerDao = new RetailerDaoImpl();
		retailerDao.setJdbcTemplate(jdbcTemplate());
		return retailerDao;
	}
}
