package Jdbcc.cts;

import java.sql.*;
 class Ccc {
	public static void main(String arg[])
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/bb","root","welcome");  
			  
			//here sonoo is database name, root is username and password  
			  
			Statement stmt=con.createStatement();  
			 
			
			int  id=105;
			String name="name5";
			//String customer_order="name6";
			//int bill=25;
			String a="insert into student values("+id+",'"+name+"')";
			stmt.executeUpdate(a);
			con.close(); 
			System.out.println("done");
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
}