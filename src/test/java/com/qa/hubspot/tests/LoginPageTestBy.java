package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.BasePage1;
import com.qa.hubspot.pages.HomePageBy;
import com.qa.hubspot.pages.LoginPageBy;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.TimeUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners(TestAllureListener.class)
public class LoginPageTestBy {
	WebDriver driver;
	BasePage1 basePage;
	Properties prop;
	LoginPageBy loginPageBy;
	HomePageBy homePageBy;
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage1();
		prop=basePage.init_prop();
		driver=basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumWait();
		loginPageBy=new LoginPageBy(driver);
		TimeUtil.mediumWait();
	}
	@Test(priority=1,description="verifying login page title test case")
	@Severity(SeverityLevel.NORMAL)
	@Description("check login page title is correct or not")
	public void verifyLoginPageTest() {
		String title=loginPageBy.getLoginPageTitle();	
		System.out.println("login page title is:"+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		}
		@Test(priority=2)
		@Severity(SeverityLevel.CRITICAL)
		@Description("check signup link on login page")
		public void verifySignUpLinkTest() {
			Assert.assertTrue(loginPageBy.verifySignUpLink());
		}
		@Test(priority=3)
		@Severity(SeverityLevel.CRITICAL)
		@Description("verifying login feature with correct credentials")
		public void hubSpotLoginTest() throws InterruptedException {
			homePageBy=loginPageBy.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
			Assert.assertEquals(homePageBy.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
			Assert.assertEquals(homePageBy.getHomePageHeaderValue(), Constants.HOME_PAGE_HEADER);
		}
		
		@AfterMethod
		public void tearDown() {
		driver.quit();	
		}
}
