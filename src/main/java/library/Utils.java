package library;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	private void events(WebDriver driver, By locator, String waitType, WebElement element, List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		switch (waitType) {
			case "visibilityByLocator":
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				break;
				
			case "clickable":
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				break;
				
			 case "visibilityByWebElement":
		            wait.until(ExpectedConditions.visibilityOf(element));
		            break;
		      
			 case "visibilityOfAllbyLocator" :
				 	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				 	break;
		            
			 case "visibilityOfAllbyElement" :
				 	wait.until(ExpectedConditions.visibilityOfAllElements(elements));
				 	break;
				 	
			 case "presence" :
				 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				 break;
				 
			 case "clickableByElement" :
				 wait.until(ExpectedConditions.elementToBeClickable(element));
				 break;
		}
	}
	
	public By visibilityOfElement(WebDriver driver, By locator ) {
		events(driver, locator, "visibilityByLocator", null, null);
		return locator;
	}
	
	public void visibilityOfElement(WebDriver driver, WebElement element ) {
		events(driver, null, "visibilityByWebElement", element, null);	
	}
	
	public void clickable(WebDriver driver, WebElement element) {
		events(driver, null, "clickableByElement", element, null);
	}
	
	public By presence(WebDriver driver, By locator ) {
		events( driver, locator, "presence", null, null);
		return locator;
	}
	public WebElement visibilityOfElementReturn(WebDriver driver, WebElement element ) {
		events(driver, null, "visibilityByWebElement", element, null);
		return element;
	}
	
	public WebElement clickableReturn(WebDriver driver, WebElement element) {
		events(driver, null, "clickableByElement", element, null );
		return element;
	}
	
	public List<WebElement> visibilityOfAllElement(WebDriver driver, List<WebElement> elements) {
		events(driver, null, "visibilityOfAllbyElement", null, elements);	
		return elements;
	}
	
	public void visibilityOfAllElement(WebDriver driver, By locator) {
		events(driver, locator, "visibilityOfAllbyLocator", null, null);	
		
	}
	
	public By clickableReturn(WebDriver driver, By locator) {
		events(driver, locator, "clickable", null, null);
		return locator;
	}
	
	public WebElement presence(WebDriver driver, WebElement element ) {
		events( driver, null, "presence", element, null);
		return element;
	}
	
	public void takeScreenshot(WebDriver driver, String testName) {
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
		String fileName = testName + "_" + timestamp + ".png";
	    Path screenshotDir = Paths.get( System.getProperty("user.dir"), "Screenshots");
	    Path destinationPath = screenshotDir.resolve(fileName);
		try {
			Files.createDirectories(screenshotDir);
			FileUtils.copyFile(sourceFile, destinationPath.toFile());
			System.out.println("Screenshot saved successfully to: " + destinationPath.toAbsolutePath());
		} catch (IOException e) {
			System.err.println("Failed to capture screenshot for test: " + testName);
			e.printStackTrace();
		}
		
	}
}
