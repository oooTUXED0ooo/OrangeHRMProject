package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.Base;
import library.ExcelUtils;
import pages.HomePage;
import pages.LoginPage;
import pages.MyInfoPage;

public class MyInfoFormTest extends Base {
	
	private MyInfoPage myInfo;
	private HomePage home;
	private LoginPage login;
	private static Logger logger = LoggerFactory.getLogger(MyInfoFormTest.class);
	
	@DataProvider(name= "infoForm")
	private Object[][] testData(){
		Object[][] data = ExcelUtils.getTestData("Sheet1");
		return data;
	}
	
	@BeforeMethod
	public void prerequisites() {
        logger.info("***********Initializing Driver***********");
        initBrowser();
        logger.info("***********Initiating LoginPage***********");
        login = new LoginPage(getDriver());  
        logger.info("**********Sending Valid Username-Password to LoginPage*************");
		login.loginApp("admin", "admin123");
		logger.info("********Initiating Homepage*********");
	    home = new HomePage(getDriver());
	    logger.info("********Finding dashboard*********");
	    home.dashboardElement();
	    logger.info("********Clicking on MyInfo Button*********");
		home.myInfoBtn();
	}
	
	@Test(dataProvider = "infoForm")
	private void infoFormTest(String firstName, String middleName, String lastName, String empId, String drivingLicenseNo,
	        String licenseExpiryYear, String licenseExpiryMonth, String licenseExpiryDate, String nationality,
	        String maritalStatus, String dobYear, String dobMonth, String dobDate, String bloodType, String testField,
	        String filePath) {
		logger.info("********Initiating infoFormTest*********");
		try {  
			logger.info("********Initiating MyInfo Page*********");
			myInfo = new MyInfoPage(getDriver());
			logger.info("********Enetering First Name*********");
			myInfo.firstNameField(firstName);
			logger.info("********Enetering Middle Name*********");
			myInfo.middleNameField(middleName);
			logger.info("********Enetering last Name*********");
			myInfo.lastNameField(lastName);
			logger.info("********Enetering Employee ID*********");
			myInfo.employeeIdField(empId);
			logger.info("********Enetering Driving License Number*********");
			myInfo.drivingLicNum(drivingLicenseNo);
			logger.info("********Enetering Driving License Expiry Date*********");
			myInfo.licenseExpiryDate(licenseExpiryYear, licenseExpiryMonth, licenseExpiryDate);
			logger.info("********Enetering Nationality*********");
			myInfo.nationalityTextField(nationality);
			logger.info("********Enetering Marital Status*********");
			myInfo.maritalStatusField(maritalStatus);
			logger.info("********Selecting Gender*********");
			myInfo.selectGender();
			logger.info("********Enetering Date of Birth*********");
			myInfo.dateOfBirthField(dobYear, dobMonth, dobDate);
			logger.info("********Enetering Blood Type*********");
			myInfo.getBloodType(bloodType);
			logger.info("********Enetering Test*********");
			myInfo.setTestFieldText(testField);
			logger.info("********Adding Attachment*********");
			myInfo.addAttachment(filePath);
			logger.info("********Validating Upload*********");
			boolean status = myInfo.validateForm();
			Assert.assertEquals(status, true);
		
		}
		catch(Exception ex) {
			String exceptionName =  ex.getClass().getSimpleName();
			String errorMsg = ex.getMessage().split("\\r?\\n")[0];
			logger.error("infoFormTest Failed : {} FOUND => {}", exceptionName, errorMsg);
			Assert.fail("Test failed due to " + exceptionName + ": " + errorMsg);
		}
	}
}
