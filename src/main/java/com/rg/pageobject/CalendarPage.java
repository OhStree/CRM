package com.rg.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rg.basepage.BasePage;

public class CalendarPage extends BasePage{
	
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calender;
	
	@FindBy(xpath = "//a[@title='New Event']")
	WebElement newEvent;
	
	public CalendarPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void mouseOverToCalende(){
		mouseHoverActionClass(calender);
		newEvent.click();
		
	}
	
	

}
