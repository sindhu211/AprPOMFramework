package com.qa.hubspot.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.TimeUtil;


public class LoginPageTest {
	WebDriver driver;
	BasePage basepage;
	Properties prop;
	LoginPage loginpage;
	@BeforeMethod
	public void setUp(){
		basepage=new BasePage();
		try {
			prop=basepage.init_prop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver=basepage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginpage=new LoginPage(driver);
	    TimeUtil.mediumWait();
		
	}
	@Test(priority=1)
	public void verifyLoginPageTest() {
	String title=loginpage.getLoginPageTitle();	
	System.out.println("login page title is:"+title);
	Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginpage.verifySignUpLink());
	}
	@Test(priority=3)
	public void hubSpotLoginTest() throws InterruptedException {
		loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
