package com.cg.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cg.entity.Customer;


public class CustomerDaoImpl implements CustomerDao{
	
	//private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
      
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
   
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	

	@Override
	public Customer addCustomer(Customer customer) {
		 String query = "insert into customer (customerId,customerName,customerAddress,paymentMode) values (?,?,?,?)";
	        Object[] inputs = new Object[] {customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerAddress(),customer.getPaymentMode()};
	        jdbcTemplate.update(query, inputs);
	        return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		String sql = "update customer set paymentMode=? where customerId = ?";
         Object[] inputs = new Object[] {customer.getPaymentMode(),customer.getCustomerId()};
        jdbcTemplate.update(sql, inputs);
		return customer;
	}

	@Override
	public int deleteCustomer(int customerId) {
		 String sql = "delete from customer where customerId = ?";
	       return jdbcTemplate.update(sql,new Object[]{customerId});
			//return 1;
		
		
	}

	



	


	
}
