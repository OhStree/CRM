package com.rg.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rg.basepage.BasePage;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement homePageLogo;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=calendar&sub=default']")
	WebElement Calendar;
	
	
	public HomePage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	
	public String getTitel(){
		String titel = driver.getTitle();
		return titel;
	}
	
	public boolean checkLogo(){
		boolean displayed = homePageLogo.isDisplayed();
		return displayed;
	}
	
	public CalendarPage Clickcalendar(){
		Calendar.click();
		return new CalendarPage();
	}

}
