package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrganizationTesting {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("D:\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String Browser = pobj.getProperty("Browser");
		String url = pobj.getProperty("Url");
		String Username = pobj.getProperty("Username");
		String Password = pobj.getProperty("Password");
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if(Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//step-1 login to app
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		//step-2 navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		//step-3 click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String name = pobj.getProperty("OrganizationName");
		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.name("button")).click();
		String textmsg = driver.findElement(By.xpath("//span[contains(text(),'Navatar -  Organization')]"))
		.getText();
		if(textmsg.contains("Navatar")) {
			System.out.println("Organization is verified");
		}
		driver.findElement(By.xpath("//td[@class='genHeaderSmall']/following-sibling::td[@class='small']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();

	}

}
