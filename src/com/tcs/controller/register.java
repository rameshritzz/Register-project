package com.tcs.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.model.customer;
import com.tcs.model.customerCRUD;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		customer newcustomer = new customer();
		newcustomer.setYname(request.getParameter("your name"));
		newcustomer.setYemail(request.getParameter("email"));
		newcustomer.setUname(request.getParameter("username"));
		String pass = request.getParameter("user_password").toString();
		String cpass = request.getParameter("confirm").toString();
		try {
			if (pass.equals(cpass)) {
				newcustomer.setUser_password(pass);
				customerCRUD c = new customerCRUD();
				if (c.addcustomer(newcustomer)) {
					request.setAttribute("status", true);
					request.setAttribute("message", "inserted successfully");
					request.setAttribute("newcustomer", new customer());

				} else {
					request.setAttribute("status", true);
					request.setAttribute("message", "not inserted successfully");
					request.setAttribute("newcustomer", new customer());
				}
			} else {
				System.out.println("inside if else");

				request.setAttribute("status", true);
				request.setAttribute("message", "pass and conpass r invalid");
				request.setAttribute("newcustomer", new customer());
			}
		}

		catch (Exception e) {
			if(e.getMessage().contains("primary key")) {
			
			request.setAttribute("status", true);
			request.setAttribute("message", "error");
			request.setAttribute("newcustomer", newcustomer);
			System.err.println(e.getMessage());

		}
		else
		{
			request.setAttribute("status", true);
			request.setAttribute("message", "sererror");
			request.setAttribute("newcustomer", newcustomer);
			System.err.println(e.getMessage());
		}
	
		rd = request.getRequestDispatcher("views/index.jsp");
		rd.forward(request, response);

	}
}}