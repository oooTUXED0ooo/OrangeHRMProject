package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import library.Utils;

public class HomePage {
	
	private Utils utils;
	private WebDriver driver;
	private static Logger logger = LoggerFactory.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver) {
		logger.info("****Initiating HomePage********");
		this.driver = driver;
		utils = new Utils();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h6[normalize-space()='Dashboard']")
	private WebElement dashboardElement;

    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    private WebElement loggedInUser;

    @FindBy(xpath = "//span[normalize-space()='My Info']")
    private WebElement myInfoBtn;

    @FindBy(xpath = "//li/a[normalize-space()='Logout']")
    private WebElement logOutButton;

	
	public WebElement dashboardElement() {
		logger.info("********Getting Dashboard Element********");
		return dashboardElement;
	}
	
	public void loggedInUser() {
		logger.info("********Checking Clickability of LoggedInUser********");
        utils.clickable(driver, loggedInUser);
        logger.info("********Clicking on LoggedInUser Button********");
        loggedInUser.click();
        logger.info("********Checking Visibility of Logout Button********");
        utils.clickable(driver, logOutButton);
	}
	
	
	public void logOutButton() {
		logger.info("********Checking Clickability of Logout Button********");
        utils.clickable(driver, logOutButton);
        logOutButton.click();
	}
	
	public void myInfoBtn() {
		logger.info("********Checking Clickability of MyInfo Button********");
        utils.clickable(driver, myInfoBtn);
        logger.info("*******Clicking on MyInfo Button********");
        myInfoBtn.click();
	}
}
