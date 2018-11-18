package com.rg.basepage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static Properties prop = null;
	public static String propPath = "E:\\Workspace\\TestNg_Testing\\Exceptio\\TestNGPOM\\src\\main\\java\\com\\rg\\property\\propertie.properties";
	//public WebDriverWait webdriverwait = null;
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
		}
	}

	public void chrome() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("driver"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void waitForElementVisible(WebElement element ,int timeout){
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}
}
