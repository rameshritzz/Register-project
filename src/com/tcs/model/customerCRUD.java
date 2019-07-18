package com.tcs.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class customerCRUD {
 public boolean addcustomer(customer c) throws ClassNotFoundException, SQLException
 {
	 Class.forName("org.h2.Driver");
	Connection con=DriverManager.getConnection("jdbc:h2:~/project", "sa", "sa");
	 PreparedStatement ps=con.prepareStatement("insert into CHECKING  values(?,?,?,?)");
	 
	ps.setString(1, c.getYname());
	ps.setString(2, c.getYemail());
	ps.setString(3, c.getUname());
	//ps.setString(4, c.getUser_password());
	if(ps.executeUpdate()!=0) {
	
	 return true;
}
	else {
		return false;
	}}
	public ArrayList<customer> SelectAllCustomer() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.h2.Driver");
		Connection con1=DriverManager.getConnection("jdbc:h2:~/project", "sa", "sa");
		Statement s=con1.createStatement();
		ResultSet rs=s.executeQuery("Select * from Customer");
	ArrayList<customer> custlist=new ArrayList<>();
	while(rs.next())
	{
		customer c=new customer();
		c.setYname(rs.getString(1));
		c.setYemail(rs.getString(2));
		c.setUname(rs.getString(3));
		custlist.add(c);
		}
	return custlist;
	}
}
