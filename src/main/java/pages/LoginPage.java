package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import library.Utils;

public class LoginPage {

    private Utils utils;
    private WebDriver driver;

    private static Logger logger = LoggerFactory.getLogger(LoginPage.class);
    
    public LoginPage(WebDriver driver) {
        logger.info("****Initiating LoginPage********");
        this.driver = driver;
        utils = new Utils();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(xpath = "//p[normalize-space()='Invalid credentials']")
    private WebElement loginCredErrorText;

    @FindBy(xpath ="//h5")
    private WebElement loginText;
    
    public String loginTextELement() {
    	utils.visibilityOfElement(driver, loginText);
    	return loginText.getText();
    } 
    
    public void enterUsername(String usernameValue) {
        logger.info("******Checking Presence of Username Field******");
        utils.visibilityOfElement(driver, username);
        logger.info("******Sending Username******");
        username.sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        logger.info("******Checking Visibility of Password Field******");
        utils.visibilityOfElement(driver, password);
        logger.info("******Sending Password******");
        password.sendKeys(passwordValue);
    }

    public void loginButtonClick() {
        logger.info("******Checking Clickability of Login Button******");
        utils.clickable(driver, loginButton);
        logger.info("******Clicking on Login Button******");
        loginButton.click();
    }

    public void setCredentialsMsg() {
        logger.info("******Checking Visibility of Login Credential Error Message****");
        utils.visibilityOfElement(driver, loginCredErrorText);
    }

    public WebElement loginCredErrorElement() {
    	setCredentialsMsg();
        return loginCredErrorText;
    }
    
    public void loginApp(String username, String password) {
    	logger.info("******Logging into app****");
    	logger.info("****Entering Username********");
		enterUsername(username);
		logger.info("****Entering Password********");
		enterPassword(password);
		logger.info("****Clicking on Login Button********");
		loginButtonClick();
    }
}
