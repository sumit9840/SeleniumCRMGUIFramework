package Practice.contactstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String Browser = pobj.getProperty("Browser");
		String URL = pobj.getProperty("Url");
		String Username = pobj.getProperty("Username");
		String Password = pobj.getProperty("Password");

		// generate random number
		Random ran = new Random();
		int ranInt = ran.nextInt();

		// read TestScript data from Excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\sumit\\OneDrive\\Desktop\\Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("contact");
		Row row = sheet.getRow(7);
		String orgName = row.getCell(2).toString() + ranInt;
		String lastName = row.getCell(3).toString() + ranInt;

		wb.close();
		WebDriver driver = null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		// enter all the details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);

		driver.findElement(By.name("button")).click();
		// verify orgName info Expected result
		String headerInfo = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (headerInfo.equals(orgName)) {
			System.out.println(orgName + "is created==>pass");
		} else {
			System.out.println(orgName + "is not created==>fail");
		}
		//navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		// enter all the details & create new organization
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		while(itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Accounts")) {
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		//switch to parent window
		Set<String> id = driver.getWindowHandles();
		Iterator<String> itr1 = id.iterator();
		while(itr1.hasNext()) {
			String windowId = itr1.next();
			driver.switchTo().window(windowId);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains("module=Contacts")) {
				break;
			}
		}
		
		driver.findElement(By.name("button")).click();
		String headerInfo1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo1.contains(lastName)) {
			System.out.println(lastName+ "is created==>pass");
		}else {
			System.out.println(lastName+ "is not created==>fail");
		}
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName+ "is created==>pass");
		}else {
			System.out.println(orgName+ "is not created==>fail");
		}
		
		driver.quit();



	}

}
