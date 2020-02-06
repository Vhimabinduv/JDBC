package Pro.cts;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
public class Proo {
public static void main(String args[])
{
	try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/l","root","welcome");  
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); // your template here
		//java.util.Date dateStr = formatter.parse(date);
			
		  
		//String date = "2020-01-23";
		Statement stmt=con.createStatement();  

		ArrayList<Person1> list = new ArrayList<Person1>();
		 
		ResultSet rs=stmt.executeQuery("select * from Person");//,rs.getDate(2)
		while(rs.next())  
		{
		Person1 s = new Person1 (rs.getInt(1),rs.getString(2),rs.getBoolean(3));
		list.add(s);
		}

		Iterator it = list.iterator();

		while(it.hasNext())
		{

		Person1 ss = (Person1)it.next();

		System.out.println( ss);
		}

		con.close();
		}
		catch(Exception e) {System.out.println(e);}

		}
		}

		class Person1{

		int id;
		String name;
		//java.util.Date date;
		boolean flag;
		public Person1()
		{

		}
		public Person1(int id, String name, boolean flag) {

		this.id = id;
		this.name = name;
		this.flag = flag;
		}
		@Override
		public String toString() {
		return "Person [id=" + id + ", name=" + name + ", flag=" + flag + "]";
		}


		}

		
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); // your template here
		java.util.Date dateStr = formatter.parse(date);
			
		Person p1 = new Person(101, "name1",  dateStr, true);
			
		java.sql.Date dateDB = new java.sql.Date(p1.dob.getTime());
			
		String insert = "insert into person2 values("+p1.pid+",'"+p1.name+"','"+dateDB+"',"+p1.flag+")";
		Statement stmt = con.createStatement();
		stmt.executeUpdate(insert);
		
		  
	con.close();
	}catch(Exception e){ System.out.println(e);
	}
}
}
class Person
{
	int pid;
	String name;
	java.util.Date dob;
	boolean flag;
	 Person(int pid, String name, java.util.Date dateStr, boolean flag) {
		this.pid = pid;
		this.name = name;
		this.dob = dob;
		this.flag = flag;	
}

}*/