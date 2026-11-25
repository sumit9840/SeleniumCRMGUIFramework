package Practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		Connection con =null;
		try {
		// step-1 load/register the database driver
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step-2 connect to database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "sumit123");
		System.out.println("====done======");
		
		//step-3 create sql statement
		Statement statement = con.createStatement();
		
		//step-4 execute selectquery & get result
		ResultSet set = statement.executeQuery("select * from actor");
		while(set.next()) {
			System.out.println(set.getString(1)+"\t"+set.getString(2)+"\t"+set.getString(3));
		}
		}catch (Exception e) {
			System.out.println("handle exception");
		}finally {
			//step-5 close the connection
			con.close();
			System.out.println("==closed connection====");
		}
		
		
		

	}

}
