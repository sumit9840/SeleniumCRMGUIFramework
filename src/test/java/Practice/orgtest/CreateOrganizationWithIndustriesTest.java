package Practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args) throws IOException {
		// read common data from properties file
		FileInputStream fis=new FileInputStream("D:\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String Browser = pobj.getProperty("Browser");
		String URL = pobj.getProperty("Url");
		String Username = pobj.getProperty("Username");
		String Password = pobj.getProperty("Password");
		
		//generate random number
		Random ran=new Random();
		int ranInt = ran.nextInt();
		
		//read TestScript data from Excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\sumit\\OneDrive\\Desktop\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("org");
		Row row = sheet.getRow(4);
		String orgName = row.getCell(2).toString()+ranInt;
		String industry = row.getCell(3).toString();
		String press = row.getCell(4).toString();
		
		wb.close();
		
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(Browser.equals("edge")){
			driver=new EdgeDriver();
		}else if(Browser.equals("firefox")){
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//enter all the details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement ele = driver.findElement(By.name("industry"));
		Select sel=new Select(ele);
		sel.selectByVisibleText(industry);
		WebElement ele2 = driver.findElement(By.name("accounttype"));
		Select sel2=new Select(ele2);
		sel2.selectByVisibleText(press);
		
		driver.findElement(By.name("button")).click();
		
		
		//verify orgName & industry & type
		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustries.equals(industry)) {
			System.out.println(industry+ "information is verified==>pass");
		}else {
			System.out.println(industry+ "information is not verified==>fail");
		}
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if(actType.equals(press)) {
			System.out.println(press + "information is verified==>pass");
		}else {
			System.out.println(press + "information is not verified==>fail");
		}
		
		
		driver.quit();
		

	}

}
