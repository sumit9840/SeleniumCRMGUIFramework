package Practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {
	@Test
	public void runtimeparameterTest() {
		String url = System.getProperty("url");
		//System.out.println("testng test");
		System.out.println("Env Data==>URL ==>"+url);
	}

}
