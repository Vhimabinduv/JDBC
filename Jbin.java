package Jdbcc.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jbin {
	public static void main(String arg[])
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/l","root","welcome");  
			  
			//here sonoo is database name, root is username and password  
			  
			Statement stmt=con.createStatement();  
			 
			
			int id=105;
			String name="name5";
			String fname="name6";
			int age=25;
			String insert="insert into mom values("+id+",'"+name+"','"+fname+"',"+age+")";
			stmt.executeUpdate(insert);
			con.close(); 
			System.out.println("done");
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
