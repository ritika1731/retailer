package com.cg;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class StoreApplicationTests {

	Customer customer=new Customer(1,"ritika","delhi","cash");
	Supplier supplier=new Supplier(101,"asd","mumbai",2,111,200.2);
	Goods goods=new Goods(121,"asd",2,200.2);
	Retailer retailer=new Retailer("qwerty","pune");

	
	@Test
	public void customerTest() {
			assertEquals(1,customer.getCustomerId());
			assertEquals("ritika",customer.getCustomerName());
			assertEquals("delhi",customer.getCustomerAddress());
			assertEquals("cash",customer.getPaymentMode());
	}
	@Test
	public void goodsTest() {
			assertEquals(121,goods.getGoodsId());
			assertEquals("asd",goods.getGoodsName());
			//assertEquals(200.2,goods.getGoodsPrice());
			assertEquals(2,goods.getGoodsQuantity());
	}
	@Test
	public void supplierTest() {
			assertEquals(101,supplier.getSupplierId());
			assertEquals("asd",supplier.getSupplierName());
			assertEquals("mumbai",supplier.getSupplierAddress());
			assertEquals(2,supplier.getQuantityOrder());
			assertEquals(111,supplier.getOrderId());
			//assertEquals("200.2",supplier.getAmount());

	}
	@Test
	public void retailerTest() {
			
			assertEquals("qwerty",retailer.getRetailerName());
			assertEquals("pune",retailer.getRetailerAddress());
		
	}

}
