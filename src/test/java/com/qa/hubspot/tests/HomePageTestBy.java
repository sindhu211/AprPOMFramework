package com.qa.hubspot.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.HomePageBy;
import com.qa.hubspot.pages.LoginPageBy;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.TimeUtil;

public class HomePageTestBy {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPageBy loginPageBy;
	HomePageBy homePageBy;
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage=new BasePage();
		try {
			prop=basePage.init_prop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver=basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPageBy=new LoginPageBy(driver);
		TimeUtil.mediumWait();
		homePageBy=loginPageBy.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority=1)
	public void verifyHomePageTitle() {
	String title=homePageBy.getHomePageTitle();
	System.out.println("home page title is:"+title);
	Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);	
	}
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
	String headerValue=homePageBy.getHomePageHeaderValue();
	System.out.println("Home Page Header is:"+headerValue);
	Assert.assertEquals(headerValue,Constants.HOME_PAGE_HEADER);

	}
	@Test(priority=3)
	public void verifyLoggedInUserAccountNameTest() {
	String accountName=homePageBy.getLoggedInAccountValue();
	System.out.println("logged in user account name is:"+accountName);
	Assert.assertEquals(accountName, prop.getProperty("accountName"));
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();	
	}

}
