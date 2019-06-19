package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.hubspot.util.DriverUtil;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.JavaScriptUtil;
import com.qa.hubspot.util.TimeUtil;


public class HomePageBy extends BasePage {
	ElementActions elementActions;
	JavaScriptUtil jsUtil;
	DriverUtil driverUtil;
	By contactMainLink=By.xpath("nav-primary-contacts-branch");
	By contactSubLink=By.xpath("nav-secondary-contacts");
    By homePageHeader=By.xpath("//h1[@class='private-page__title']");
	By accountName=By.xpath("//span[contains(text(),'NaveenAutomationLabs')]");
	
	WebDriver driver;
	public  HomePageBy(WebDriver driver) {
		this.driver=driver;
		elementActions =new ElementActions(driver);
		driverUtil=new DriverUtil(driver);
			}
	public String getHomePageTitle() {
		 return driverUtil.getHomePageTitle();
		
	}
    public String getHomePageHeaderValue() {
    	return elementActions.doHeader(homePageHeader);
    	
    }
    public String getLoggedInAccountValue() {
    	
    	return elementActions.doLoggedIn(accountName);
    	
    }
    public ContactsPageBy goToContactsPage() throws Exception {
    	
    	jsUtil.clickElementByJS(driver.findElement(contactMainLink));
    	TimeUtil.mediumWait();
    	jsUtil.clickElementByJS(driver.findElement(contactSubLink));
        
    	return new ContactsPageBy(driver);
    }
   
//    public void clickOnContacts()throws Exception {
//
//    	driver.findElement(contactMainLink);
//    	TimeUtil.mediumWait();
//        driver.findElement(contactSubLink);   }
}
    

