package Practice.datadriventesting;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRuntime {
         
	@Test
	public void seleniumTest() throws IOException, ParseException {
		JSONParser parse=new JSONParser();
		Object obj = parse.parse(new FileReader("D:\\appCommonData.json"));
		JSONObject map=(JSONObject)obj;
		
		String Browser = map.get("browser").toString();
		String url = map.get("url").toString();
		String Username =map.get("username").toString();
		String Password = map.get("password").toString();
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
		driver.quit();
	}

}
