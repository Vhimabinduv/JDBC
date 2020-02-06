package proj.cts;
		import java.sql.*;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.text.DateFormat;
		import java.text.ParseException;
		import java.text.SimpleDateFormat;
		import java.util.*;

		import com.mysql.cj.xdevapi.Statement;



		public class Allpr  {

		public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		List<Person> list = new ArrayList<Person>();

		

		//if start
		
		System.out.println("how many record you want to insert");
		int n = s.nextInt();


		Person[] p= new Person[n];
		int i = 0;

		for( int j=0; j<n; j++ )
		{
		p[j] = new Person();
		}
		//p[0] = new Person();

		while(i<n)
		{

		//take input
		int id = s.nextInt();
		s.nextLine();
		String name = s.nextLine();
		String dob = s.next();
		boolean status = s.nextBoolean();

		//dateformat
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

		//string to date
		java.util.Date date = formatter.parse(dob);

		//add element to add() method
		p[i].add(id, name, date, status);
		i++;


		System.out.println("array list of inserted data");
		for(int j=0; j<n; j++)
		{
		list.add(p[j]);
		}


		   for(Person l : list)
		{
		   
		    //Date date = Calendar.getInstance().getTime();  
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		    String strDate = dateFormat.format(l.date);  
		   
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); // your template here
		//java.util.Date db = formatter.parse(l.date.toString());
		System.out.println(l.id+" "+l.name+" "+l.status+" "+strDate);
		}


		//try block
		try{  
		//driver connecting
		Class.forName("com.mysql.cj.jdbc.Driver");  
		 
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306 /person","root","welcome");

		i=0;
		//inserting into table
		while(i<n)
		{
		String sql ="insert into student values(?,?,?,?)";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1,p[i].id);
		pstmt.setString(2,p[i].name);

		java.sql.Date dateDB = new java.sql.Date(p[i].date.getTime());
		pstmt.setDate(3,dateDB);
		pstmt.setBoolean(4,p[i].status);

		int re = pstmt.executeUpdate();
		if(re==1)
		System.out.println("success...");
		else
		System.out.println("Fail.....");
		i++;
		}
		}

		//catch statement
		catch(Exception e){ System.out.println(e);
		}
		}




	
		s.close();
		
		}


		

		}
		



		class Person
		{

		int id;
		String name;
		java.util.Date date;
		boolean status;
		public void add(int id, String name, java.util.Date date, boolean status)
		{
		this.id = id;
		this.name = name;
		this.date = date;
		this.status = status;
		}

		}

