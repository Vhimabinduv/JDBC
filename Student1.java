package Pro.cts;
//package jdbcApp;
import java.sql.*;
import java.util.*;

public class Student1 {

	public static void main(String[] args) {
		try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/person","root","welcome");

		Statement stmt=con.createStatement();  

		ArrayList<Student> list = new ArrayList<Student>();
		 
		ResultSet rs=stmt.executeQuery("select * from student");
		while(rs.next())  
		{
		Student s = new Student (rs.getInt(1),rs.getString(2),rs.getBoolean(3));
		list.add(s);
		}

		Iterator it = list.iterator();

		while(it.hasNext())
		{

		Student ss = (Student)it.next();

		System.out.println( ss);
		}

		con.close();
		}
		catch(Exception e) 
		{
			System.out.println(e);
			
		}

		}
}

		class Student{

		int id;
		String name;
		boolean flag;
		public Student(int id, String name, boolean flag) 
		{
		this.id = id;
		this.name = name;
		this.flag = flag;
		}
	/*	@Override
		public String toString() {
		return "Student [id=" + id + ", name=" + name + ", flag=" + flag + "]";
		}*/
		@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", flag=" + flag + "]";
		}
		}



