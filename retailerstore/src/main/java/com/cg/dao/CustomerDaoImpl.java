package com.cg.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import com.cg.entity.Customer;


public class CustomerDaoImpl implements CustomerDao{
	
	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
      
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


	@Override
	public Customer addCustomer(Customer customer) {
		 String query = "insert into customer (customerId,customerName,customerAddress,paymentMode) values (?,?,?,?)";
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        Object[] inputs = new Object[] {customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(),customer.getPaymentMode()};
	        jdbcTemplate.update(query, inputs);
	        return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		/*entityManager.merge(customer);
		entityManager.flush();
		return customer;*/return customer;
	}

	@Override
	public Customer deleteCustomer(Customer customer) {
		
		 String query = "delete from customer (customerId,customerName,customerAddress,paymentMode) where customerId=?";
	        jdbcTemplate = new JdbcTemplate(dataSource);
	        Object[] inputs = new Object[] {customer.getCustomerId()};
	        jdbcTemplate.update(query, inputs);
	        return customer;
		
		
	}

}
