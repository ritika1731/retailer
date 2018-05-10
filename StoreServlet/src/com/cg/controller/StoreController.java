package com.cg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.entity.Customer;
import com.cg.exception.StoreException;
import com.cg.service.CustomerService;
import com.cg.service.RetailerService;

/**
 * Servlet implementation class StoreController
 */
//@WebServlet("/storeController")
public class StoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CustomerService custService = (CustomerService) context.getBean("customerService");
	RetailerService retailerService = (RetailerService) context.getBean("retailerService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String qStr= request.getParameter("action");
		System.out.println("in do get:"+qStr);
		RequestDispatcher dispatch=null;
		if("addNew".equals(qStr))
		{
			dispatch=request.getRequestDispatcher("addNew.jsp");
			
			dispatch.forward(request, response);
			
			
		}
		
		System.out.println(request.getParameter("addNew"));
		System.out.println("in do post:"+qStr);
		String qString= request.getParameter("addNew");

		if("addNew".equals(qString))
		{System.out.println("in do:"+qString);
			String id=request.getParameter("customerId");
			System.out.println("my id"+id);
			int customerId = Integer.parseInt(id);
			String customerName=request.getParameter("customerName");
			String customerAddress=request.getParameter("customerAddress");
			String paymentMode=request.getParameter("paymentMode");

			Customer cust=new Customer();
			cust.setCustomerId(customerId);
			System.out.println(customerId);
			cust.setCustomerName(customerName);
			cust.setCustomerAddress(customerAddress);
			cust.setPaymentMode(paymentMode);
		
			try{
				cust=custService.addCustomer(cust);
				if(cust==null)
				{
					throw new StoreException("unable to insert");
				}
				else
				{
					request.setAttribute("customerId", cust.getCustomerId());
					dispatch=request.getRequestDispatcher("success.jsp");
					dispatch.forward(request, response);
				}
			}
			catch(StoreException e)
			{
				dispatch=request.getRequestDispatcher("error.jsp");
				request.setAttribute("errorMsg", e.getMessage());
				dispatch.forward(request, response);

			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String qStr= request.getParameter("action");
		RequestDispatcher dispatch=null;

		if("viewAllCustomer".equals(qStr))
		{
			try {
				List<Customer> list=retailerService.retrieveCustomer();
				request.setAttribute("listCustomer", list);
				dispatch=request.getRequestDispatcher("home.jsp");
				dispatch.forward(request, response);
			} catch (StoreException e) {
				dispatch=request.getRequestDispatcher("error.jsp");
				request.setAttribute("errorMsg", e.getMessage());
				dispatch.forward(request, response);
			}
			
			
		}
		
	}

	
}
