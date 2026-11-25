package Practice.datadriventesting;

import java.util.Random;

public class GenerateRandomNumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		int randomint = random.nextInt(1000);
		System.out.println(randomint);

	}

}
