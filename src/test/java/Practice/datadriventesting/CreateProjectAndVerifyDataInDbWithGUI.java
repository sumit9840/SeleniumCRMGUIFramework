package Practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDbWithGUI {

	public static void main(String[] args) throws SQLException {
		
		String projectName = "Instagram_1";
		boolean flag = false;
		//created project in fe or gui using selenium
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8084");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("sign in")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("create project")).click();
		
		driver.findElement(By.name("projectName")).sendKeys("projectName");
		driver.findElement(By.name("createdBy")).sendKeys("sumit");
		Select sele = new Select(driver.findElement(By.name("status")));
		sele.selectByVisibleText("On Going");
		driver.findElement(By.xpath("add project")).click();
		
		//verify the project in db
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3036/projects", "root", "sumit123");
		Statement stat = conn.createStatement();
		ResultSet set = stat.executeQuery("select * from projects");
		while(set.next()) {
			String actProjectName = set.getString(4);
			if(projectName.equals(actProjectName)) {
				flag=true;
				System.out.println(projectName+ "is available==>pass");
			}
		}
		if(flag==false) {
			System.out.println(projectName+ "is not available==>fail");
			Assert.fail();
		}
		
		
		conn.close();
		
		
	}

}
