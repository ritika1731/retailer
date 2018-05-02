package com.cg.RetailerStore;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.cg.controller.ApplicationConfiguration;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
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

		Customer customer = new Customer(1, "ritika", "mumbai", "cash");
		//	CustomerDao customerService;
		Customer value=custService.addCustomer(customer);
		assertEquals(1, value);
	}
	@Test
	public void goodsTest() {

		Goods goods = new Goods(101, "ritika", 2,1212);
		//	CustomerDao customerService;
		Goods value=goodsService.addGoods(goods);
		assertEquals(1, value);
	}
	@Test
	public void supplierTest() {

		Supplier sup = new Supplier(121, "shruti", "pune", 2,1,200);
		//	CustomerDao customerService;
		Supplier value=supplierService.addSupplier(sup);
		assertEquals(1, value);
	}
	@Test
	public void customerRemoveTest() {

		//Customer customer = new Customer(1, "ritika", "mumbai", "cash");
		//	CustomerDao customerService;
		Customer value=custService.deleteCustomer(1);
		assertEquals(1, value);
	}
	@Test
	public void goodsRemoveTest() {

		//Goods goods = new Goods(101, "ritika", 2,1212);
		//	CustomerDao customerService;
		Goods value=goodsService.deleteGoods(101);
		assertEquals(1, value);
	}
	@Test
	public void supplierRemoveTest() {

		//Supplier sup = new Supplier(1, "shruti", "pune", 2,1,200);
		//	CustomerDao customerService;
		Supplier value=supplierService.deleteSupplier(121);
		assertEquals(1, value);
	}
}
