package Practice.homeTest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSampleTest {
 
	@Test
	public void homePageTest(Method mtd) {
		Reporter.log(mtd.getName()+" test started");
		
		SoftAssert assertobj=new SoftAssert();
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		Assert.assertEquals("Home", "Home");
		Reporter.log("Step-3",true);
		assertobj.assertEquals("Title", "Title-1");
		Reporter.log("Step-4",true);
		assertobj.assertAll();
		Reporter.log(mtd.getName()+" test end");
		
	}
	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		Reporter.log(mtd.getName()+" test started");
		SoftAssert assertobj=new SoftAssert();
		
		Reporter.log("Step-1",true);
		Reporter.log("Step-2",true);
		assertobj.assertTrue(true);
		Reporter.log("Step-3",true);
		Reporter.log("Step-4",true);
		assertobj.assertAll();
		Reporter.log(mtd.getName()+" test end");
		
	}
}
