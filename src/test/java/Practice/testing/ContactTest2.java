package Practice.testing;

import org.testng.annotations.Test;

public class ContactTest2 {

	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest with-->HDFC");
		
	}
	@Test(dependsOnMethods ="createContactTest" )
	public void modifyContactTest() {
		
		System.out.println("execute modifyContactTest-->HDFC=>ICICI");
	}
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		
		System.out.println("execute deleteContactTest ICICI");
	}
}
