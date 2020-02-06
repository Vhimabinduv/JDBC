package Kirru.cts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Bk {
	public static void main(String arg[])
	{
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/bb","root","welcome");  
			  
			//here sonoo is database name, root is username and password  
			  
			/*Statement stmt=con.createStatement();  
			 
			
			
			String name="firstname";
			int  id=520;
			//String customer_order="name6";
			//int bill=25;
			//String a="insert into student values("+id+",'"+name+"')";
			String update = "UPDATE student set name='"+name+"' where id= "+122+"";
			stmt.executeUpdate(update);
			con.close(); 
			System.out.println("done");*/
			
			//String sql="insert into student values() ";
		//preparedStatement pstmt =con.preparedStatement(sql);
			//PreparedStatement pstmt = con.prepareStatement("insert into student values(?,?)");
		//pstmt.setInt(1, 102);
			//pstmt.setString(2, "Sanal");
			
		PreparedStatement pstmt = con.prepareStatement("update student set name=? ,id=?  where id = ?");
		
		pstmt.setString(1,"binn" );
		pstmt.setInt(2,105 );
		pstmt.setInt(3,102 );
		
		pstmt.executeUpdate();
	
			//pstmt.setString(3, "PSTMT");
			//pstmt.setInt(4, 24);
			
			int res = pstmt.executeUpdate();
			if(res == 1) {
				System.out.println("update .........");
			}
			
			System.out.println("Done .....");
					
					
					
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
