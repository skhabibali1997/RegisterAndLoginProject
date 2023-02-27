package com.techpalle.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		String path = request.getServletPath();
		
		switch(path) 
		{
		case "/logCustomer":
			validateCustomer(request, response);
			break;
		case "/regCustomer":
			insertCustomer(request, response);
			break;
		
		case "/log":
			getLoginPage(request, response);
			break;
		case "/reg":
			getRegistrationPage(request, response);
			break;
			
			default:
				getStartUpPage(request,response);
				break;
		}
		
		String name = request.getParameter("tbName");
		String mobile = request.getParameter("tbMobile");
		String gender = request.getParameter("tbGender");
		String qualification = request.getParameter("ddlQual");
		String state = request.getParameter("ddlState");
		String email = request.getParameter("tbEmail");
		String password = request.getParameter("tbPass");
		
		
		
	}

	
	private void validateCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		//Read the email and password from login.jsp page
		String e = request.getParameter("tbEmailLog");
		String p = request.getParameter("tbPassLog");
		
		//call the method present in DAO
		boolean res = DataAccess.validateCustomer(e, p);
		
		//Condition and Redirect user to destination page(success.jsp)
		if(res)
		{
			try 
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				
				//store the SuccessPage class data inside 
				SuccessPage sp = new SuccessPage();
				request.setAttribute("successDetails", sp);
				
				rd.forward(request, response);
			} 
			catch (ServletException e1) 
			{
				e1.printStackTrace();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		else 
		{
			getLoginPage(request, response);
		}
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		// Read the data from jsp page
		
		String name = request.getParameter("tbName");
		long mobile = Long.parseLong(request.getParameter("tbMobile"));
		String gender = request.getParameter("tbGender");
		String qualification = request.getParameter("ddlQual");
		String state = request.getParameter("ddlState");
		String email = request.getParameter("tbEmail");
		String password = request.getParameter("tbPass");
		
		// storethat data in customer page
		Customer cust = new Customer(name, mobile, gender, qualification, state, email, password);
		
		// call insertCustomer method present in dao package
		DataAccess.insertCustomer(cust);
		
		try 
		{
			RequestDispatcher rd =request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		
		try 
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}


