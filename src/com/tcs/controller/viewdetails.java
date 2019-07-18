package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tcs.model.customer;
import com.tcs.model.customerCRUD;

/**
 * Servlet implementation class viewdetails
 */
@WebServlet("/viewdetails")
public class viewdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customerCRUD c=new customerCRUD();
		try {
			
		ArrayList<customer> newlist=c.SelectAllCustomer();
		request.setAttribute("custlist", newlist);
		RequestDispatcher rd=request.getRequestDispatcher("views/dispdetails.jsp");
		rd.forward(request, response);
		}
	catch (Exception e) {
		e.printStackTrace();
	}
		
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
