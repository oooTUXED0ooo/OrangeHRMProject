package tests;

import library.ExtentReportListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import library.Base;
import pages.HomePage;
import pages.LoginPage;

@Listeners(ExtentReportListener.class)
public class LoginTest extends Base{
	private LoginPage login;
	private HomePage home ;
	private static Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void prerequisites() {
        logger.info("***********Initializing Driver***********");
        initBrowser();
        logger.info("***********Initiating LoginPage***********");
        login = new LoginPage(getDriver());        
	}
	
	@Test
	public void loginSuccessTest()  {
		logger.info("****Initiating loginSuccessTest********");
		logger.info("**********Sending Valid Username-Password to LoginPage*************");
		login.loginApp("admin", "admin13");
		try {
			home = new HomePage(getDriver());
			logger.info("*****Verifying Dashboard********");
			String dashboardText = home.dashboardElement().getText();
			Assert.assertEquals(dashboardText, "Dashboard");
		}
		catch(Exception ex) {
			String exceptionName =  ex.getClass().getSimpleName();
			String errorMsg = ex.getMessage().split("\\r?\\n")[0];
			logger.error("loginSuccessTest Failed : {} FOUND => {}", exceptionName, errorMsg);
			Assert.fail();
		}
		
	}
	
	@Test
	public void logOutSuccessTest() {
		logger.info("**********Sending Username-Password to LoginPage*************");
		login.loginApp("admin", "admin123");
		logger.info("**********Loading HomePage*************");
		home = new HomePage(getDriver());
		logger.info("**********Clicking on Logged in User*************");
		home.loggedInUser();
		logger.info("**********Clicking on Logout Button*************");
		home.logOutButton();
		logger.info("***********Verifying Login Page is Displayed after logout********");
		try {
			logger.info("*****Verifying Logout********");
			String loginTextCheck = login.loginTextELement();
			Assert.assertEquals(loginTextCheck, "Login");
		}
		catch(Exception ex) {
			String exceptionName =  ex.getClass().getSimpleName();
			String errorMsg = ex.getMessage().split("\\r?\\n")[0];
			logger.error("logOutSuccessTest Failed : {} FOUND => {}", exceptionName, errorMsg);
			Assert.fail("Test failed due to " + exceptionName + ": " + errorMsg);
		}
	}
	
	@Test
	public void loginFailedTest() throws Exception{
		logger.info("*******Initiating loginFailedTest********");
		logger.info("**********Sending Invalid Username-Password to LoginPage*************");
		try {
			login.loginApp("admin", "admin13");
			logger.info("**********Verifying Login Error Message*************");
			String errorMsg = login.loginCredErrorElement().getText();
			Assert.assertEquals(errorMsg, "Invalid credentials");
		}
		catch(Exception ex) {
			String exceptionName =  ex.getClass().getSimpleName();
			String errorMsg = ex.getMessage().split("\\r?\\n")[0];
			logger.error("loginFailedTest Failed : {} FOUND => {}", exceptionName, errorMsg);
			Assert.fail("Test failed due to " + exceptionName + ": " + errorMsg);
		}	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}
}	
