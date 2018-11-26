package com.rg.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rg.basepage.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(xpath ="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath ="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath ="//input[@type='submit']")
	WebElement submit;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	
	}
	
	public String getTitel(){
		String titel;
		titel = driver.getTitle();
		return titel;
	}
	
	public HomePage testLogin(String uname,String psw){
		
		username.sendKeys(uname);
		password.sendKeys(psw);
		clickByjavaScriptExecuter(submit);
	
		
		//submit.click();
		return new HomePage();
		
	}
	
}
