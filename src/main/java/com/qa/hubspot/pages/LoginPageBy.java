package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.util.DriverUtil;
import com.qa.hubspot.util.ElementActions;

import io.qameta.allure.Step;

public class LoginPageBy extends BasePage1 {
	//By Locators
	//Non Page Factory pattern;
	ElementActions elementActions;
	DriverUtil driverUtil;
	By emailID=By.id("username");
	By Password=By.id("password");
	By loginButton=By.id("loginBtn");
	By SignUpLink=By.linkText("Sign up");
	WebDriver driver;
	
	//create the constructor of the page class:
	public  LoginPageBy(WebDriver driver) {
		this.driver=driver;
		elementActions =new ElementActions(driver);
		driverUtil=new DriverUtil(driver);
	}
//Define page Actions/Methods
	@Step("getting login page title step..")
	public String getLoginPageTitle() {
		return driverUtil.getLoginPageTitle();
	}
	@Step("checking signup link is displayed with is displayed method step..")
    public boolean verifySignUpLink() {
    	return elementActions.elementIsDisplayed(SignUpLink);
    }
	@Step("login to app with username:{0} and password:{1}")
    public HomePageBy doLogin(String username,String pwd) {
    	elementActions.doSendKeys(emailID, username);;
    	elementActions.doSendKeys(Password, pwd);;
    	elementActions.doClick(loginButton);;


    	
        return new HomePageBy(driver);

    	
    }
}
