package com.cg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;
import com.cg.service.RetailerService;

/**
 * Servlet implementation class StoreController
 */
@WebServlet("/storeController")
public class StoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CustomerService custService = (CustomerService) context.getBean("customerService");
	RetailerService retailerService = (RetailerService) context.getBean("retailerService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<Customer> list=retailerService.retrieveCustomer();
		System.out.println(list);
		HttpSession session=request.getSession(true);

		session.setAttribute("listCustomer", list);
		RequestDispatcher dispatch=request.getRequestDispatcher("index.jsp");
		dispatch.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
