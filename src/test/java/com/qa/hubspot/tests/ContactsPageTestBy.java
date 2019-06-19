package com.qa.hubspot.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.pages.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.ContactsPageBy;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.HomePageBy;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pages.LoginPageBy;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ExcelUtil;
import com.qa.hubspot.util.TimeUtil;

public class ContactsPageTestBy {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPageBy loginPageBy;
	HomePageBy homePageBy;
	ContactsPageBy contactsPageBy;
	
	
	@BeforeMethod
	public void setUp() throws Exception {
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
		TimeUtil.mediumWait();
		contactsPageBy=homePageBy.goToContactsPage();
	}
		@Test(priority=1)
		public void verifyContactsPageHeaderTest() {
		AssertJUnit.assertTrue(contactsPageBy.verifyContactsPageHeader());
		}
//		@Test(priority=2,enabled=false)
//		public void createNewContactTest() {
//			contactsPage.createNewContact("Arun1@gmail.com", "Arun1","kumar1", "QA lead");
//		}
		@DataProvider(name="getContactsData")
		public Object[][] getContactsTestData(){
		Object contactsData[][]=ExcelUtil.getTestData("contacts");
		return contactsData;
		}
		@Test(priority=2,dataProvider="getContactsData")
		public void createNewContactTest(String email,String firstName,String lastName,String jobTitle) {
			contactsPageBy.createNewContact(email, firstName, lastName, jobTitle);
		}
		
		
		@AfterMethod
		public void tearDown() {
		driver.quit();	
		}
	

}
