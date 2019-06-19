package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	//1.define your page objects
	//2.define page actions/methods
	//Page Objects:with page factory and without page factory
	@FindBy(id="username")
	WebElement emailId;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="loginBtn")
	WebElement LoginButton;
	@FindBy(partialLinkText="Sign")
	WebElement SignUpLink;

	//create the constructor of this page class
	public LoginPage(WebDriver driver) {
    this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public boolean verifySignUpLink() {
		return SignUpLink.isDisplayed();
		
	}
	public HomePage doLogin(String username,String pwd) throws InterruptedException {
		emailId.sendKeys(username);
		password.sendKeys(pwd);
		LoginButton.click();
		Thread.sleep(7000);
		//System.out.println(driver.getTitle());
		return new HomePage(driver);
		
		
	}

}
