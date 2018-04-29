package com.cg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entity.Customer;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class StoreApplicationTests {

	Customer customer=new Customer(1,"ritika","delhi","cash");
	
	@Test
	public void contextLoads() {
			assertEquals(1,customer.getCustomerId());
			assertEquals("ritika",customer.getCustomerName());
			assertEquals("delhi",customer.getCustomerAddress());
			assertEquals("cash",customer.getPaymentMode());
	}
	

}
