package Practice.testing;

import org.testng.annotations.Test;

public class OrderTest1 {
	
	@Test(invocationCount = 10)
	public void createOrderTest() {
		System.out.println("Execute createOrderTest==>123");
		
	}
	
	@Test(enabled = false)
	public void billingOrderTest() {
		System.out.println("Execute billingOrderTest==>123");
	}

}

