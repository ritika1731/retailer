package com.cg.RetailerStore;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cg.controller.ApplicationConfiguration;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;
import com.cg.service.CustomerService;
import com.cg.service.GoodsService;
import com.cg.service.RetailerService;
import com.cg.service.SupplierService;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class RetailerStoreApplicationTests {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

		/*CustomerDao customerDao = context.getBean("custdao", CustomerDaoImpl.class);
		GoodsDaoImpl testGood = context.getBean("gooddao", GoodsDaoImpl.class);*/

		CustomerService custService = (CustomerService) context.getBean("customerService");
		GoodsService goodsService = (GoodsService) context.getBean("goodsService");
		SupplierService supplierService = (SupplierService) context.getBean("supplierService");
		RetailerService retailerService = (RetailerService) context.getBean("retailerService");
	


	@Test
	public void customerTest() {

		Customer customer = new Customer(13, "rahul", "mumbai", "card");
		//	CustomerDao customerService;
		Customer value=custService.addCustomer(customer);
		assertEquals(customer, value);
	}
	@Test
	public void goodsTest() {

		Goods goods = new Goods(125, "ritika", 2,1322);
		//	CustomerDao customerService;
		Goods value=goodsService.addGoods(goods);
		assertEquals(goods, value);
	}
	@Test
	public void supplierTest() {

		Supplier sup = new Supplier(152, "shruti", "pune", 2,1,500);
		//	CustomerDao customerService;
		Supplier value=supplierService.addSupplier(sup);
		assertEquals(sup, value);
	}
	@Test
	public void retailerTest() {

		Retailer retail = new Retailer(159, "Priya", "Lucknow");
		//	CustomerDao customerService;
		Retailer value=retailerService.addRetailer(retail);
		assertEquals(retail, value);
	}
	@Test
	public void customerRemoveTest() {

		
		int value=custService.deleteCustomer(13);
		assertEquals(1, value);
	}
	@Test
	public void goodsRemoveTest() {

		
		int value=goodsService.deleteGoods(125);
		assertEquals(1, value);
	}
	@Test
	public void supplierRemoveTest() {

	
		int value=supplierService.deleteSupplier(152);
		assertEquals(1, value);
	}
	
	@Test
	public void customerUpdateTest() {
		Customer cust = new Customer(11, "rahul", "mumbai", "card");
		cust.setCustomerId(11);
		cust.setPaymentMode("asd");
		
		Customer value=custService.updateCustomer(cust);
		assertEquals(cust, value);
	}
	@Test
	public void goodsUpdateTest() {
		Goods goods = new Goods(125, "ritika", 2,1322);
		goods.setGoodsId(102);
		goods.setGoodsName("Fridge");
		
		Goods value=goodsService.updateGoods(goods);
		assertEquals(goods, value);
	}
	@Test
	public void supplierUpdateTest() {
		Supplier sup = new Supplier(151, "shruti", "pune", 2,1,500);
		sup.setSupplierId(151);
		sup.setAmount(7500);
		Supplier value=supplierService.updateSupplier(sup);
		assertEquals(sup, value);
	}
	/*@Test
	public void retrieveCustomerTest() {
		 
		List<Customer> value=retailerService.retrieveCustomer();
		assertEquals(1, value);
	}
	@Test
	public void retrieveGoodsTest() {
		 
		List<Goods> value=retailerService.retrieveGoods();
		assertEquals(1, value);
	}
	@Test
	public void retrieveSupplierTest() {
		 
		List<Supplier> value=retailerService.retrieveSupplier();
		assertEquals(1, value);
	}*/
	
}
