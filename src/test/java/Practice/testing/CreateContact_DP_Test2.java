package Practice.testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 {
	@Test(dataProvider = "getData")
	public void createContactTest(String firstName,String lastName,String phoneNumber) {
		System.out.println("FirstName :"+firstName+ " LastName :"+lastName+" phoneNumber "+phoneNumber);
	}
	
	@DataProvider
	public Object [][] getData(){
		Object [][] objarr=new Object [3][3];
		objarr[0][0]="sumit";
		objarr[0][1]="HR";
		objarr[0][2]="9087654321";
		
		objarr[1][0]="sam";
		objarr[1][1]="sh";
		objarr[1][2]="8907654321";
		
		objarr[2][0]="john";
		objarr[2][1]="smith";
		objarr[2][2]="7890654321";
		
		return objarr;
	}

}
