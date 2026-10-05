package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import library.Utils;

public class MyInfoPage {

    private Utils utils;
    private WebDriver driver;
    private JavascriptExecutor js;
    private static Logger logger = LoggerFactory.getLogger(MyInfoPage.class);
    
    
    public MyInfoPage(WebDriver driver) {
        logger.info("**********Initiating MyInfoPage**********");
        this.driver = driver;
        utils = new Utils();
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[contains(@class,'orangehrm-firstname')]")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[contains(@class,'orangehrm-middlename')]")
    private WebElement middleNameField;

    @FindBy(xpath = "//input[contains(@class,'orangehrm-lastname')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[text()='Employee Id']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
    private WebElement empIdField;

    @FindBy(xpath = "//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input")
    private WebElement driverLicenseNumField;

    @FindBy(xpath = "//label[text()='License Expiry Date']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input")
    private WebElement licenseExpiryField;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    private WebElement nationalityField;

    @FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']/div")
    private List<WebElement> nationalityOptions;

    @FindBy(xpath = "//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement maritalField;

    @FindBy(xpath = "//div[contains(@class, 'oxd-select-dropdown')]/div")
    private List<WebElement> maritalOptions;

    @FindBy(xpath = "//div[@class='oxd-calendar-selector-year-selected']/p[@class='oxd-text oxd-text--p']")
    private WebElement licenseExpiryYear;

    @FindBy(xpath = "//div[@class='oxd-calendar-selector-month-selected']/p")
    private WebElement licenseExpiryMonth;

    @FindBy(xpath = "//i[@class='oxd-icon bi-chevron-left']")
    private WebElement previousYearButton;

    @FindBy(xpath = "//i[@class='oxd-icon bi-chevron-right']")
    private WebElement nextYearButton;

    @FindBy(xpath = "//ul[@class='oxd-calendar-dropdown']/li")
    private List<WebElement> monthOptions;

    @FindBy(xpath = "//div[@class='oxd-calendar-dates-grid']/div")
    private List<WebElement> dateOptions;

    @FindBy(xpath = "//label[text()='Date of Birth']/parent::div/following-sibling::div//input")
    private WebElement dateOfBirthField;

    @FindBy(xpath = "//label[text()='Date of Birth']/parent::div/following-sibling::div//li[@class='oxd-calendar-selector-year']//p")
    private WebElement birthYear;

    @FindBy(xpath = "//label[text()='Date of Birth']/parent::div/following-sibling::div//i[@class='oxd-icon bi-chevron-left']")
    private WebElement birthPreviousYearButton;

    @FindBy(xpath = "//label[text()='Date of Birth']/parent::div/following-sibling::div//i[@class='oxd-icon bi-chevron-right']")
    private WebElement birthNextYearButton;

    @FindBy(xpath = "//div[@class='oxd-calendar-selector-month-selected']/p")
    private WebElement birthMonth;

    @FindBy(xpath = "//label[normalize-space()='Male']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//label[normalize-space()='Blood Type']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']")
    private WebElement bloodTypeField;

    @FindBy(xpath = "//div[contains(@class,'oxd-select-dropdown')]/div")
    private List<WebElement> bloodTypeOptions;

    @FindBy(xpath = "//label[normalize-space()='Test_Field']/parent::div/following-sibling::div/input")
    private WebElement testField;

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElement attachmentButton;

    @FindBy(xpath = "//input[@class='oxd-file-input']")
    private WebElement attachmentFile;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']/following::button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class, 'oxd-table-cell')][2]//child::div")
    private List<WebElement> recordTable;

    public void firstNameField(String firstName) {
        logger.info("**********Checking Visibility of First Name Field*************");
        WebElement nameFirst = utils.visibilityOfElementReturn(driver, firstNameField);             
        logger.info("**********Clicking Inside First Name Field*************");
        nameFirst.click();
        logger.info("**********Selecting Previous First Name*************");
        nameFirst.sendKeys(Keys.CONTROL, "a");
        logger.info("**********Overwriting First Name*************");
        nameFirst.sendKeys(firstName);
    }

    public void middleNameField(String middleName) {
        logger.info("**********Checking Visibility of Middle Name Field*************");
        WebElement midName = utils.visibilityOfElementReturn(driver, middleNameField);                
        logger.info("**********Selecting Previous Middle Name*************");
        midName.sendKeys(Keys.CONTROL, "a");
        logger.info("**********Overwriting Middle Name*************");
        midName.sendKeys(middleName);
    }

    public void lastNameField(String lastName) {
        logger.info("**********Checking Visibility of Last Name Field*************");
        WebElement nameLast = utils.visibilityOfElementReturn(driver, lastNameField);               
        logger.info("**********Selecting Previous Last Name*************");
        nameLast.sendKeys(Keys.CONTROL, "a");
        logger.info("**********Overwriting Last Name*************");
        nameLast.sendKeys(lastName);
    }

    public void employeeIdField(String empId) {
        logger.info("**********Checking Visibility of Employee ID Field*************");
        utils.visibilityOfElement(driver, empIdField);
        logger.info("**********Selecting Previous Employee ID*************");
        empIdField.sendKeys(Keys.CONTROL, "a");
        logger.info("**********Overwriting Employee ID*************");
        empIdField.sendKeys(empId);
    }

    public void drivingLicNum(String licenseNum) {
        logger.info("**********Checking Visibility of Driving License Number Field*************");
        utils.visibilityOfElement(driver, driverLicenseNumField);
        logger.info("**********Selecting Previous Driving License Number*************");
        driverLicenseNumField.sendKeys(Keys.CONTROL, "a");
        logger.info("**********Overwriting Driving License Number*************");
        driverLicenseNumField.sendKeys(licenseNum);
    }

    public void licenseExpiryDate(String year, String month, String date) {
        logger.info("**********Checking Clickability of License Expiry Field*************");
        WebElement licenseExpiry = utils.clickableReturn(driver, licenseExpiryField);               
        logger.info("**********Clicking on License Expiry Field*************");
        licenseExpiry.click();
        logger.info("***********Checking Visibility of License Expiry Year************");
        utils.visibilityOfElement(driver, licenseExpiryYear);
        int currentYear = Integer.parseInt(licenseExpiryYear.getText());
        int targetYear = Integer.parseInt(year);
        if (currentYear < targetYear) {
        	logger.info("***********Clicking Next Year************");
            while (!licenseExpiryYear.getText().equals(year)) {               
                utils.clickable(driver, nextYearButton);
                nextYearButton.click();
            }
        }
        else if (currentYear > targetYear) {
        	logger.info("***********Clicking Previous Year************");
            while (!licenseExpiryYear.getText().equals(year)) {                
                utils.clickable(driver, previousYearButton);
                previousYearButton.click();
            }
        }
        logger.info("***********Clicking Month************");
        utils.clickable(driver, licenseExpiryMonth);
        licenseExpiryMonth.click();
        logger.info("***********Reading all Months************");
        utils.visibilityOfAllElement(driver, monthOptions);
        for (WebElement monthOption : monthOptions) {
            if (monthOption.getText().equalsIgnoreCase(month)) {
                logger.info("***********Clicking Desired Month************");
                utils.clickable(driver, monthOption);
                monthOption.click();
                break;
            }
        }
        logger.info("***********Reading all Dates************");
        utils.visibilityOfAllElement(driver, dateOptions);
        for (WebElement dateOption : dateOptions) {
            if (dateOption.getText().equals(date)) {
                logger.info("***********Clicking Desired Date************");
                utils.clickable(driver, dateOption);
                dateOption.click();
                break;
            }
        }
    }

    public void nationalityTextField(String nationality) {
        logger.info("**********Checking Clickability of Nationality Field*************");
        WebElement nationalityElement =  utils.clickableReturn(driver, nationalityField);
        logger.info("**********Scrolling to Nationality Field*************");
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", nationalityElement);                                     
        logger.info("***********Clicking on Nationality Field************");
        nationalityElement.click();
        logger.info("***********Reading Nationality Dropdown************");
        utils.visibilityOfAllElement(driver, nationalityOptions);
        for (WebElement nation : nationalityOptions) {
            if (nation.getText().equals(nationality)) {
                logger.info("***********Clicking Desired Nationality************");
                nation.click();
                break;
            }
        }
    }

    public void maritalStatusField(String maritalStatus) {
        logger.info("**********Checking Clickability of Marital Status Field*************");
        utils.clickable(driver, maritalField);
        logger.info("***********Clicking on Marital Status Field************");
        maritalField.click();
        logger.info("***********Reading Marital Status Dropdown************");
        utils.visibilityOfAllElement(driver, maritalOptions);
        for (WebElement maritalOption : maritalOptions) {
            if (maritalOption.getText().equalsIgnoreCase(maritalStatus)) {
                logger.info("***********Clicking Desired Marital Status************");
                maritalOption.click();
                break;
            }
        }
    }

    public void dateOfBirthField(String year, String month, String date) {
        logger.info("**********Checking Clickability of Date of Birth Field*************");
        utils.clickable(driver, dateOfBirthField);
        logger.info("**********Clicking on Date of Birth Field*************");
        dateOfBirthField.click();
        logger.info("***********Checking Visibility of Birth Year************");
        utils.visibilityOfElement(driver, birthYear);
        int current = Integer.parseInt(birthYear.getText());               
        int target = Integer.parseInt(year);             
        if (current > target) {
        	logger.info("***********Clicking Previous Birth Year************");
            while (!birthYear.getText().equals(year)) {               
                utils.clickable(driver, birthPreviousYearButton);
                birthPreviousYearButton.click();
            }
        }
        else if (current < target) {
        	logger.info("***********Clicking Next Birth Year************");
            while (!birthYear.getText().equals(year)) {                
                utils.clickable(driver, birthNextYearButton);
                birthNextYearButton.click();
            }
        }
        logger.info("***********Checking Clickability of Birth Month************");
        utils.clickable(driver, birthMonth);
        logger.info("***********Clicking Birth Month************");
        birthMonth.click();
        logger.info("***********Reading Birth Month Dropdown************");
        utils.visibilityOfAllElement(driver, monthOptions);
        for (WebElement monthOption : monthOptions) {
            if (monthOption.getText().equalsIgnoreCase(month)) {
                logger.info("***********Clicking Desired Birth Month************");
                monthOption.click();
                break;
            }
        }
        logger.info("***********Reading Birth Date Grid************");
        utils.visibilityOfAllElement(driver, dateOptions);
        for (WebElement dateOption : dateOptions) {
            if (dateOption.getText().equals(date)) {
                logger.info("***********Clicking Desired Birth Date************");
                dateOption.click();
                break;
            }
        }
    }

    public void selectGender() {
        logger.info("***********Checking Visibility of Male Button************");
        utils.visibilityOfElement(driver, maleRadioButton);
        logger.info("***********Clicking on Male Gender************");
        maleRadioButton.click();
    }

    public void getBloodType(String bloodType) {
        logger.info("***********Checking Clickability of Blood Type Field************");
        utils.clickable(driver, bloodTypeField);
        logger.info("***********Clicking on Blood Type Field************");
        bloodTypeField.click();
        logger.info("***********Reading Blood Type Dropdown************");
        utils.visibilityOfAllElement(driver, bloodTypeOptions);
        for (WebElement bloodOption : bloodTypeOptions) {
            if (bloodOption.getText().equalsIgnoreCase(bloodType)) {
                logger.info("***********Clicking Desired Blood Type************");
                bloodOption.click();
                break;
            }
        }
    }

    public void setTestFieldText(String text) {
        logger.info("***********Checking Visibility of Test Field************");
        utils.visibilityOfElement(driver, testField);
        logger.info("***********Selecting Previous Test************");
        testField.sendKeys(Keys.CONTROL, "a");
        logger.info("***********Overwriting Test************");
        testField.sendKeys(text);
    }

    public void addAttachment(String filepath) {
        logger.info("***********Checking Clickability of Add Attachment Button************");
        utils.clickable(driver, attachmentButton);
        logger.info("***********Clicking Add Attachment Button************");
        attachmentButton.click();
        logger.info("***********Sending File Path************");
        attachmentFile.sendKeys(filepath);                      
        logger.info("***********Checking Visibility of Save Button************");
        utils.visibilityOfElement(driver, saveButton);
        logger.info("***********Clicking Save Button************");
        saveButton.click();
    }

    public boolean validateForm() {
        String fileName = "jumble.txt";
        boolean flag = false;
        logger.info("***********Checking Uploaded File Table************");
        utils.visibilityOfAllElement(driver, recordTable);
        for (WebElement recordIndex : recordTable) {
            System.out.println(recordIndex.getText());
            if (recordIndex.getText().equals(fileName)) {
                System.out.println("The File has been successfully UPLOADED." );                                     
                flag = true;
                break;
            }
        }
        return flag;
    }
}
