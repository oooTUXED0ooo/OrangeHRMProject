package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerTestDemo.class)
public class TestScifi {
	
	@BeforeMethod
	public void starting() {
		System.out.println("*******STARTING TestScifi**************");
	}
	
	
	@Test ()
	public void alpha() {
		System.out.println("-----------ALPHA----------");
	}

	@Test (groups = "regression")
	public void beta()  {
		System.out.println("-----------BETA----------");
	}
	
	@Test (groups = "smoke")
	public void gama( ) {	
		System.out.println("-----------GAMA----------");
	}
	
	@Test(groups = "sanity")
	public void theta() {
		System.out.println("-----------THETA----------");
	}
	
	@AfterMethod
	public void ending() {
		System.out.println("*******Ending TestScifi**************");
	}
}
