import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenShot {

	@Test
	public void amazonTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		/*
		 * //step-1 create an object to eventfiring EventFiringWebDriver edriver=new
		 * EventFiringWebDriver(driver); File srcFile =
		 * edriver.getScreenshotAS(OutputType.FILE); FileUtils.copyFile(srcFile, new
		 * file("gvhh"));
		 */
	}
}
