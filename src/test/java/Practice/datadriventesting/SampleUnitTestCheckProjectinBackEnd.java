package Practice.datadriventesting;

import static org.testng.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectinBackEnd {
	@Test
	public void projectCheckTest() throws SQLException {
		String expected_name="sumit";
		boolean flag = false;
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","sumit123");
		
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery("select * from actor");
		while(set.next()) {
			String actual_name = set.getString(2);
			if(expected_name.equals(actual_name)) {
				System.out.println(expected_name+"is available pass");
				flag=true;
			}
		}
		if(flag==false) {
			System.out.println(expected_name +"is not available==>fail");
		Assert.fail();
		}
	}

}
