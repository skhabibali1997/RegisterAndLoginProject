package com.techpalle.dao;

import java.sql.*;

import com.techpalle.model.Customer;

public class DataAccess 
{
	private static final String dburl ="jdbc:mysql://localhost:3306/project";
	private static final String dbusername ="root";
	private static final String dbpassword ="admin12345";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String insertQry = "insert into customer(name, mobile, gender, qualification, state, email, password) values(?,?,?,?,?,?,?)";

	private static final String validateQry = "select email,password from customer where email=? and password=?";
	
	public static boolean validateCustomer(String email, String password) 
	{
		boolean b = false;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dburl,dbusername,dbpassword);
			
			ps = con.prepareStatement(validateQry);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			b = rs.next();
			
			//String e = rs.getString("email");
			//String p = rs.getString("password");
			
			//if(e.equals(email) && e.equals(password)) 
			//{
			//	b= true;
			//}
				
		} 
		
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
		finally 
		{ 
			if(rs!=null) 
			{
				try 
				{
					rs.close();
			    } 
			    catch (SQLException e1)
			    {
			    	e1.printStackTrace();
			    }
			}	
		 
			if(ps!=null)
				{
					try 
					{
						ps.close();
					} 
					catch (SQLException e1) 
					{
						
						e1.printStackTrace();
					}
				}
				if(con!=null) 
				{
					try 
					{
						con.close();
					} 
					catch (SQLException e1) 
					{
						
						e1.printStackTrace();
					}
				}
				
			
			
		}
		return b;
	}
	
	public static void insertCustomer(Customer customer) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(dburl,dbusername,dbpassword);
			
			ps = con.prepareStatement(insertQry);
			ps.setString(1, customer.getName());
			ps.setLong(2, customer.getMobile());
			ps.setString(3, customer.getGender());
			ps.setString(4, customer.getQualification());
			ps.setString(5, customer.getState());
			ps.setString(6, customer.getEmail());
			ps.setString(7, customer.getPassword());
			
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
		 
			if(ps!=null)
				{
					try 
					{
						ps.close();
					} 
					catch (SQLException e) 
					{
						
						e.printStackTrace();
					}
				}
				if(con!=null) 
				{
					try 
					{
						con.close();
					} 
					catch (SQLException e) 
					{
						
						e.printStackTrace();
					}
				}
				
			
			
		}
	}
}
