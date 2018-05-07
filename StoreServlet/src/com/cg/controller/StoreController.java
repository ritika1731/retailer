package com.cg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/storeController")
public class StoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	
	CustomerService custService = (CustomerService) context.getBean("customerService");
	RetailerService retailerService = (RetailerService) context.getBean("retailerService");

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*RequestDispatcher requestDispatcher=null;
		try {
			List<Customer> customerList = retailerService.retrieveCustomer();
			System.out.println("xads11");
					request.setAttribute("list", customerList);
					System.out.println("wewr11");

					 requestDispatcher = request.getRequestDispatcher("index.jsp");
					System.out.println("poi11");

					requestDispatcher.forward(request, response);
					System.out.println("mnb11");
		} catch (Exception e) {
			requestDispatcher=request.getRequestDispatcher("error.jsp");
			request.setAttribute("errorMsg", e.getMessage());
			requestDispatcher.forward(request, response);
		}*/
		String qStr= request.getParameter("action");
	//	HttpSession session=request.getSession(true);
		RequestDispatcher dispatch=null;
		if("addCustomer".equals(qStr))
		{
			 dispatch=request.getRequestDispatcher("addNew.jsp");
			dispatch.forward(request, response);
		}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	/*	List<Customer> customerList = retailerService.retrieveCustomer();
	System.out.println("xads");
		request.setAttribute("list", customerList);
		System.out.println("wewr");

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		System.out.println("poi");

		requestDispatcher.forward(request, response);
		System.out.println("mnb");*/

	}

}
