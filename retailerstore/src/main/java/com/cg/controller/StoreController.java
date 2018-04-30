  package com.cg.controller;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.cg.dao.CustomerDao;
import com.cg.dao.GoodsDao;
import com.cg.entity.Customer;
import com.cg.entity.Goods;

@Controller
public class StoreController {

	

	public static void main(String[] args) {

		 
        String confFile = "applicationContext.xml";
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
        CustomerDao custDao = (CustomerDao) context.getBean("customerDao");
        GoodsDao goodsDao = (GoodsDao) context.getBean("goodsDao");

       Customer cust = new Customer();
        cust.setCustomerId(1);
        cust.setCustomerName("ritika");
        cust.setCustomerAddress("mumbai");
        cust.setPaymentMode("cash");
        cust.setCustomerId(2);
        cust.setCustomerName("aishwarya");
        cust.setCustomerAddress("ny");
        cust.setPaymentMode("card");
        custDao.addCustomer(cust);
	    
//        cust.setCustomerId(2);
//        custDao.deleteCustomer(cust);
        
        
        Goods goods = new Goods();
        goods.setGoodsId(101);
        goods.setGoodsName("TV");
        goods.setGoodsPrice(1000);
        goods.setGoodsQuantity(1);
        goodsDao.addGoods(goods);

	}

}
