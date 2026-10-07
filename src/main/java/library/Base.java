package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	protected Properties properties;
	private FileInputStream fin;
	private Logger logger = LoggerFactory.getLogger(Base.class);
	private EdgeOptions options;
	
	public WebDriver getDriver() {
		return driver.get();
	}
	public Base() {
		options = new EdgeOptions();
		options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		options.addArguments("--headless=new");
		properties = new Properties();
		try {
			fin = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			properties.load(fin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void initBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			logger.info("***********LAUNCHING CHROME BROWSER***********");
			driver.set(new EdgeDriver(options));
		}
		else {
			logger.info("***********LAUNCHING EDGE BROWSER***********");
			driver.set(new EdgeDriver(options));
		}
		
		getDriver().get(properties.getProperty("url"));
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	}
}
