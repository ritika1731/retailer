package com.cg.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.dao.CustomerDao;
import com.cg.dao.GoodsDao;
import com.cg.dao.RetailerDao;
import com.cg.dao.SupplierDao;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;
import com.cg.service.CustomerService;
import com.cg.service.GoodsService;
import com.cg.service.RetailerService;
import com.cg.service.SupplierService;

@Configuration
public class StoreController {



	/**
	 * @param args
	 */
	
	public static void main(String[] args) {

		 ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	      	
		/*CustomerDao custDao = (CustomerDao) context.getBean("customerDao");
		GoodsDao goodsDao = (GoodsDao) context.getBean("goodsDao");
		SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
		RetailerDao retailerDao = (RetailerDao) context.getBean("retailerDao");*/
		
		CustomerService custService = (CustomerService) context.getBean("customerService");
		GoodsService goodsService = (GoodsService) context.getBean("goodsService");
		SupplierService supplierService = (SupplierService) context.getBean("supplierService");
		RetailerService retailerService = (RetailerService) context.getBean("retailerService");

		//insert Customer details to Customer table
		Customer cust = new Customer(1,"ritika","mumbai","cash");
		Customer cust1 = new Customer(2,"tuhin","china","card");
		Customer cust2 = new Customer(3,"prince","pune","cash");
		custService.addCustomer(cust2);

		// delete Customer
		cust.setCustomerId(2);
		custService.deleteCustomer(2);


		//update Customer
		cust.setCustomerId(1);
		cust.setPaymentMode("asd");
		custService.updateCustomer(cust);

		//search by Id
//		String custDetails = retailerDao.retrieveCustomer(1);
//		System.out.println("customerDetails"+custDetails);


		//insert Goods details to Goods table
		Goods goods = new Goods(101,"TV",1,1000);
		Goods goods1 = new Goods(105,"Microwave",2,6000);

		goodsService.addGoods(goods1);

		// delete goods
		goods.setGoodsId(105);
		goodsService.deleteGoods(105);

		//update goods
		goods.setGoodsId(102);
		goods.setGoodsName("Fridge");
		goodsService.updateGoods(goods);

		//insert Supplier details to Supplier table
		Supplier supplier = new Supplier(111,"Ram","Ranchi",1,141,7000);
		Supplier supplier1 = new Supplier(121,"Shyam","UP",2,151,7050);

		supplierService.addSupplier(supplier);
		supplierService.addSupplier(supplier1);
		// delete goods

		supplier.setSupplierId(121);
		supplierService.deleteSupplier(121);

		
		//update goods
		supplier.setSupplierId(121);
		supplier.setAmount(7500);
		supplierService.updateSupplier(supplier);

		//insert Retailer details to Retailer table
		Retailer retail = new Retailer(201,"Shruti","Punjab");
		

		//retailerDao.addGoods(retail);
		String custDetail = retailerService.retrieveCustomer(2);
		System.out.println("Customer Details: "+custDetail);
	}

}
