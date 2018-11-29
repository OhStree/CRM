package com.rg.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.rg.basepage.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//td[@class='logo_text']")
	WebElement homePageLogo;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/system/index.cfm?action=calendar&sub=default']")
	WebElement Calendar;
	
	@FindBy(xpath="//ul[@class='mlddm']/li/a")
	List<WebElement> titels;
	
	@FindBy(xpath="//frame[@name='mainpanel']")
	WebElement frame;
	
	List<String> l2 = new ArrayList<>();
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void get_Tab_Titles(){
		l2.add("HOME");
		l2.add("CALENDAR");
		l2.add("COMPANIES");
		l2.add("CONTACTS");
		l2.add("DEALS");
		l2.add("TASKS");
		l2.add("CALL");
		l2.add("EMAIL");
		l2.add("TEXT/SMS");
		l2.add("PRINT");
		l2.add("CAMPAIGNS");
		l2.add("FORMS");
		l2.add("REPORTS");
		l2.add("DOCS");
		l2.add("CASES");
		
		switchToFrame(frame);
		List<String> l1 = new ArrayList<>();
		for (WebElement webElement : titels) {
			l1.add(webElement.getText().trim());
		}
		//System.out.println(l1.size()+"      "+l2.size());
		Assert.assertTrue(l1.equals(l2));
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
