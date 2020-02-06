package Jdbc.cts;
import java.sql.*;
public class Jdbc {
public static void main(String args[])
{
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/l","root","welcome");  
		  
		//here sonoo is database name, root is username and password  
		  
		Statement stmt=con.createStatement();  
		 
		ResultSet rs=stmt.executeQuery("select * from mom");  
		  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		  
	con.close();  
		/*int id=105;
		String name="name5";
		int age=25;
		String insert="insert into roll values("+id+")";
		con.close();  */
	}catch(Exception e){ System.out.println(e);
	}
}
}
