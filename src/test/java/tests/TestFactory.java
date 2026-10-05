package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;

public class TestFactory {
	
	@BeforeMethod
	public void starting() {
		System.out.println("*******STARTING TestFactory**************");
	}
	
	
	@Factory
	public Object[] createInstances() {
		return new Object[] {
			new DemoLoginTest("user1", "pass1"),
	        new DemoLoginTest("user2", "pass2")
	        };
	}
	 
	@AfterMethod
	public void ending() {
		System.out.println("*******STARTING TestFactory**************");
	}	

}
