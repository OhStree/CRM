package com.rg.pageobject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.rg.basepage.BasePage;

public class CalendarPage extends BasePage{
	
	@FindBy(xpath="//a[@title='Calendar']")
	WebElement calender;
	
	@FindBy(xpath = "//a[@title='New Event']")
	WebElement newEvent;
	
	@FindBy(xpath="//frame[@name='mainpanel']")
	WebElement frame;
	
	@FindBy(xpath="//table[@class='crmcalendar']/tbody/tr/td/table/tbody/tr/td")
	List<WebElement> dateTable;
	
	@FindBy(xpath="//select[@name='slctMonth']")
	WebElement monthDropdown;
	
	@FindBy(xpath="//select[@name='slctMonth']/option")
	List<WebElement> selectMonth;
	
	@FindBy(xpath="//select[@name='slctYear']")
	WebElement yearDropdown;
	
	@FindBy(xpath="//select[@name='slctYear']/option")
	List<WebElement> selectYear;
	
	public CalendarPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void mouseOverToCalende(){
		//switchToFrame(frame);
		waitForElementVisible(calender, 30);
		mouseHoverActionClass(calender);
		newEvent.click();
	}
	
	public void ClickOnCaleneder(String day, String month, String year){
		boolean flag = false;
		calender.click();
		for(WebElement count : dateTable){
			if(day.equalsIgnoreCase(count.getText())){
				flag = true;
			}
			else if(month.equalsIgnoreCase(count.getText())){
				flag =true;
			}
			else if(year.equalsIgnoreCase(count.getText())){
				flag =true;
			}	
			
		}
		if(flag){
			System.out.println("welcome");
		}
		
	}

	public void selectCalenederDate(String day, String month, String year) {
		calender.click();
		for(WebElement CRMmonth :selectMonth){
			if(CRMmonth.getText().equalsIgnoreCase(month)){
				Select drop = new Select(monthDropdown);
				drop.selectByVisibleText(month);
			}
		}
		
		for(WebElement CRMyear :selectYear){
			if(CRMyear.getText().equalsIgnoreCase(month)){
				Select drop = new Select(yearDropdown);
				drop.selectByVisibleText(year);
			}
		}
		
	}
	
	

}
