package com.rg.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rg.basepage.BasePage;
import com.rg.pageobject.CalendarPage;
import com.rg.pageobject.LoginPage;

public class CalenderTest extends BasePage{
	
	LoginPage loginpage = new LoginPage();
	CalendarPage calendarPage = new CalendarPage();
	
	public CalenderTest() {
		// TODO Auto-generated constructor stub
		super();
	}

	@BeforeMethod
	public void beforeMethod() {
	
		initializer();
		LoginPage loginpage = new LoginPage();
		loginpage.testLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	

	@Test
	public void calender() {
		
		calendarPage.mouseOverToCalende();

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
