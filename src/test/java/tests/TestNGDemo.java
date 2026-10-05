package tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(ListenerTestDemo.class)
public class TestNGDemo {
	
	@DataProvider(name = "loginData")
	public Object[][] getData(){
		return new Object[][]{
			{"user1", "pass1"},
			{"user2", "pass2"}
		};
	}
	
	@Test(groups = "regression")
	@Parameters({"browser", "url"})
	public void parameterTest(String browser, String url) {
		System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);
	}
	
	@Test(dataProvider = "loginData", groups = "smoke")
	public void loginDemoTest( String username,  String password) {
		 System.out.println(username + " : " + password);
	}
	
	@BeforeMethod
	public void starting() {
		System.out.println("*******STARTING TestNGDemo**************");
	}
	
	@Test (groups = "sanity")
	public void testA() {
		System.out.println("******TEST A*********");
	}
	
	@Test 
	public void testB() {
		System.out.println("******TEST B*********");
	}
	
	@Test 
	public void testC() {
		System.out.println("********TEST C*******");
	}
	
	@Test
	public void testD() {
		System.out.println("*******TEST D********");
	}
	
	@Test 
	public void testE() {
		System.out.println("******TEST E*********");
	} 
	
	@AfterMethod 
	public void ending() {
		System.out.println("*******ENDING TestNGDemo**************");
	}
}
