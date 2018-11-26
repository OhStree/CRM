package com.rg.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rg.basepage.BasePage;
import com.rg.pageobject.HomePage;
import com.rg.pageobject.LoginPage;

public class TestLogin extends BasePage{
	LoginPage loginPage =null;
	HomePage homePage;
	
	public TestLogin() {
		super();
	}
	
	@BeforeMethod
	public void setting(){
		initializer();
		loginPage = new LoginPage();
	}
	

	@Test(priority=1)
	public void getTitel(){
		String loginPageTitel = loginPage.getTitel();
		Assert.assertEquals(loginPageTitel, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test(priority=2)
	public void testLogin(){
		homePage= loginPage.testLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
//	@Test(priority=3)
//	public void checkHomePageTitel(){
//		homePage= loginPage.testLogin(prop.getProperty("username"), prop.getProperty("password"));
//		String homePageTitel =  homePage.getTitel();
//		Assert.assertEquals(homePageTitel, "CRMPRO");
//	}
	
	
	@AfterMethod
	public void clear(){
		driver.quit();
	}

}
