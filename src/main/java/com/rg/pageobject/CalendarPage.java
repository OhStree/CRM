package com.rg.pageobject;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//table[@class='crmcalendar']//table//td")
	List<WebElement> selectDay;
	
	@FindBy(xpath="//table[@class='journal']//td[@class='journalrowtime']")
	List<WebElement> selectMeetinTime;
	
	@FindBy(xpath="//td[@class='journalrowempty'][@align='right']")
	List<WebElement> selectCallForParticularTime;
	
	
 	
	
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

	
//		Select dropYear = new Select(yearDropdown);
//		dropYear.selectByValue(year.trim());
//		
//		waitForElementVisible(monthDropdown, 30);
//		
//		Select dropMonth = new Select(monthDropdown);
//		dropMonth.selectByVisibleText(month.trim());
//		
//		waitForElementVisible(monthDropdown, 30);
//		
//		String dateXpath = "//td[@class=\"calendarcell\"][contains(text(),'"+day.trim()+"')]";
//		
//		driver.findElement(By.xpath(dateXpath)).click();
//		
//		waitForElementVisible(monthDropdown, 30);

		//select month
		
		
		for(WebElement CRMmonth :selectMonth){
			if(CRMmonth.getText().equalsIgnoreCase(month)){
				Select drop = new Select(monthDropdown);
				drop.selectByVisibleText(month);
				break;
			}
		}
		//select year
		for(WebElement CRMyear :selectYear){
			if(CRMyear.getText().equalsIgnoreCase(year)){
				Select drop = new Select(yearDropdown);
				drop.selectByVisibleText(year);
				break;
			}
		}
		//select day
		for(WebElement CRMday :selectDay){
			if(CRMday.getText().equalsIgnoreCase(day)){
				CRMday.click();
				break;
			}
		}	
	}
	
	public void takeMeetingCall(String day, String month, String year ,String time){
		calender.click();
		
		Select drop = new Select(monthDropdown);
		drop.selectByVisibleText(month);
		Select drop2 = new Select(yearDropdown);
		drop2.selectByVisibleText(year);
		/*
		for(WebElement CRMmonth :selectMonth){
			if(CRMmonth.getText().equalsIgnoreCase(month)){
				Select drop = new Select(monthDropdown);
				drop.selectByVisibleText(month);
				break;
			}
		}
		//select year
		for(WebElement CRMyear :selectYear){
			if(CRMyear.getText().equalsIgnoreCase(year)){
				Select drop = new Select(yearDropdown);
				drop.selectByVisibleText(year);
				break;
			}
		}*/
	
		//select day
		for(WebElement CRMday :selectDay){
			if(CRMday.getText().equalsIgnoreCase(day)){
				CRMday.click();
				break;
			}
		}	
		
		
		for(int i=0;i<selectMeetinTime.size();i++ ){
			//selectCallForParticularTime
				System.out.println(selectMeetinTime.get(i).getText());
			if(selectMeetinTime.get(i).getText().equalsIgnoreCase(time)){
				System.out.println("clicked");
				selectCallForParticularTime.get(i).click();
				break;
			}
		}

		
	}
	
}
