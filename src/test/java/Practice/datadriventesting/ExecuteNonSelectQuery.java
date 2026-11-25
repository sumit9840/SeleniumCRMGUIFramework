package Practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteNonSelectQuery {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "sumit123");
		Statement stat = conn.createStatement();
		int result = stat.executeUpdate(" insert into actor values('203','gopal','soni','2025-09-03');");
         System.out.println(result);
         conn.close();
	}

}
