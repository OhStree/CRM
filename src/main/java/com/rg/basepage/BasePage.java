package com.rg.basepage;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop = null;
	public static String propPath = "C:\\Users\\Rohit Gaikwad\\Desktop\\TestNGPOM\\src\\main\\java\\com\\rg\\property\\propertie.properties";
	private JavascriptExecutor executor =null;
	private Actions action=null;

	public BasePage() {
		try {
			FileInputStream fis = new FileInputStream(propPath);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initializer() {
		switch ((prop.getProperty("browser"))) {
		case "chrome":
			chrome();
	
		
		case "IE":
			chrome();
		case "safari":
			chrome();

		}
	}

	public void chrome() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	public void Firefox(){
		
		System.setProperty("webdriver.gecko.driver", prop.getProperty("driver"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public void IE(){
		
		
	}
	
	public void waitForElementVisible(WebElement element ,int timeout){
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void clickByjavaScriptExecuter(WebElement element){
		waitForElementVisible(element,20);
		 executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void mouseHoverActionClass(WebElement element){
		waitForElementVisible(element,20);
		action = new Actions(driver);
        action.moveToElement(element).build().perform();
	}
}
