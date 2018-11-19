package com.rg.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rg.basepage.BasePage;
import com.rg.pageobject.CalendarPage;
import com.rg.pageobject.HomePage;
import com.rg.pageobject.LoginPage;

public class TestHomepage extends BasePage{
	
	LoginPage loginPage =null;
	HomePage homePage = null;
	CalendarPage calendarPage = null;
	
	public TestHomepage() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	@BeforeMethod
	public void setting(){
		initializer();
		loginPage = new LoginPage();
		homePage=  loginPage.testLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
	}
	

	@Test(priority=1)
	public void getTitel(){
		String homepageTitel = homePage.getTitel();
		Assert.assertEquals(homepageTitel, "CRMPRO");
	}
	
	@Test(priority=2)
	public CalendarPage clicCalendar(){
		calendarPage = homePage.Clickcalendar();
		return new CalendarPage();
	}
	
	
	@AfterMethod
	public void clear(){
		driver.quit();
	}
	

}
