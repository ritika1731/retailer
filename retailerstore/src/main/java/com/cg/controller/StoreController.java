  package com.cg.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.cg.dao.CustomerDao;
import com.cg.dao.GoodsDao;
import com.cg.dao.RetailerDao;
import com.cg.dao.SupplierDao;
import com.cg.entity.Customer;
import com.cg.entity.Goods;
import com.cg.entity.Retailer;
import com.cg.entity.Supplier;

@Controller
public class StoreController {

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 
        String confFile = "applicationContext.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
        CustomerDao custDao = (CustomerDao) context.getBean("customerDao");
        GoodsDao goodsDao = (GoodsDao) context.getBean("goodsDao");
        SupplierDao supplierDao = (SupplierDao) context.getBean("supplierDao");
        RetailerDao retailerDao = (RetailerDao) context.getBean("retailerDao");

        //insert Customer details to Customer table
		 Customer cust = new Customer();
		  cust.setCustomerId(1);
		 cust.setCustomerName("ritika");
		 cust.setCustomerAddress("mumbai");
		 cust.setPaymentMode("cash");
		  cust.setCustomerId(2);
		 cust.setCustomerName("aishwarya");
		 cust.setCustomerAddress("ny");
		 cust.setPaymentMode("card");
		  cust.setCustomerId(4);
		 cust.setCustomerName("tuhin");
		 cust.setCustomerAddress("sector 20");
		 cust.setPaymentMode("chillar");
		 custDao.addCustomer(cust);
		 
		// delete Customer
		 cust.setCustomerId(2);
		 custDao.deleteCustomer(2);
        
        //update Customer
		 cust.setCustomerId(3);
        cust.setPaymentMode("cash");
       
        custDao.updateCustomer(cust);

        
        //search by Id
        String custDetails = retailerDao.retrieveCustomer(1);
        System.out.println("customerDetails"+custDetails);
        
        
        //insert Goods details to Goods table
        Goods goods = new Goods();
    	 goods.setGoodsId(101);
        goods.setGoodsName("TV");
        goods.setGoodsPrice(1000);
        goods.setGoodsQuantity(1);
        
        goods.setGoodsId(102);
        goods.setGoodsName("Fruit");
        goods.setGoodsPrice(500);
        goods.setGoodsQuantity(10);
        goodsDao.addGoods(goods);
        
        goods.setGoodsId(103);
        goods.setGoodsName("Snacks");
        goods.setGoodsPrice(300);
        goods.setGoodsQuantity(5);
        goodsDao.addGoods(goods);
        
     // delete goods
     		 goods.setGoodsId(102);
     		 goodsDao.deleteGoods(102);
             
             //update goods
              goods.setGoodsId(102);
             goods.setGoodsName("Fridge");
            goodsDao.updateGoods(goods);
        
        //insert Supplier details to Supplier table
        Supplier supplier = new Supplier();
        supplier.setSupplierId(111);
        supplier.setSupplierName("Ram");
        supplier.setSupplierAddress("Ranchi");
        supplier.setQuantityOrder(1);
        supplier.setOrderId(141);
        supplier.setAmount(7000);
        supplierDao.addSupplier(supplier);
        
        supplier.setSupplierId(121);
        supplier.setSupplierName("Shyam");
        supplier.setSupplierAddress("up");
        supplier.setQuantityOrder(2);
        supplier.setOrderId(151);
        supplier.setAmount(7050);
        supplierDao.addSupplier(supplier);
        
        // delete goods

        supplier.setSupplierId(121);
		 supplierDao.deleteSupplier(121);
        
        //update goods
         supplier.setSupplierId(121);
        supplier.setAmount(7500);
       supplierDao.updateSupplier(supplier);
        
        //insert Retailer details to Retailer table
        Retailer retail = new Retailer();
        retail.setRetailerId(201);
        retail.setRetailerName("shruti");
        retail.setRetailerAddress("punjab");
        
        //retailerDao.addGoods(retail);
        String custDetail = retailerDao.retrieveCustomer(2);
        System.out.println("Customer Details: "+custDetail);
	}

}
