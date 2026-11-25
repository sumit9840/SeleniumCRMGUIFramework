//package Training;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

//public class WorkingWithDropDown {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//		driver.findElement(By.xpath("//button[text()='Remove']")).click();
//		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));
//		//WebElement ele = driver.findElement(By.xpath("//p[@id='message']"));

		//WebElement ele1 = w.until(ExpectedConditions.invisibilityOf((WebElement) By.xpath("//p[@id='message']")));
		/*String text = ele1.getText();
		if (text.equals("It's gone!")) {
			System.out.println("Checkbox removed");
		}
		driver.close();

	}

}*/
