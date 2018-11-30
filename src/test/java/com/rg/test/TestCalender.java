package com.rg.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rg.basepage.BasePage;
import com.rg.pageobject.CalendarPage;
import com.rg.pageobject.HomePage;
import com.rg.pageobject.LoginPage;

public class TestCalender extends BasePage {

	private static final String String = null;
	LoginPage loginpage = null;
	CalendarPage calendarPage = null;
	HomePage homePage = null;

	public TestCalender() {
		// TODO Auto-generated constructor stub
		super();
	}

	@BeforeMethod
	public void beforeMethod() {
		initializer();
		loginpage = new LoginPage();
		homePage = loginpage.testLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.get_Tab_Titles();
		calendarPage = new CalendarPage();
	}

	@Test
	public void clickOnCalanderTabANDClickNewEvent() {
		
		calendarPage.mouseOverToCalende();
	}

	@Test
	public void calenderDisplayedOrNot(){
		String day = "10";
		String month = "May";
		String year = "2018";
		calendarPage.ClickOnCaleneder(day,month,year);
		
	}
	
	@Test
	public void setDate(){
		String day = "10";
		String month = "May";
		String year = "2000";
		calendarPage.selectCalenederDate(day,month,year);
	}
	
	@Test
	public void setEvent(){
		String day = "11";
		String month = "May";
		String year = "2011";
		String time = "07:00 AM";
		calendarPage. takeMeetingCall( day,  month,  year , time);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		//driver.quit();
	}

}
