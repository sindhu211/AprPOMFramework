package com.qa.hubspot.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.pages.BasePage;

public class DriverUtil extends BasePage {
	WebDriver webdriver;
	public DriverUtil(WebDriver driver) {
		this.driver=driver;
	}
	public String getLoginPageTitle() {
		String title=null;
		try {
			title=driver.getTitle();
		}catch(Exception e) {
			System.out.println("Some esception occured while getting the title");
		}
		return title;
	}
	public void waitForElement() {
		WebDriverWait wait=new WebDriverWait(driver,Constants.DEFAULT_EXPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
	}
	public String getHomePageTitle() {
		waitForElement();
		String title=null;
		try {
			title=driver.getTitle();
		}catch(Exception e) {
			System.out.println("Some esception occured while getting the title");
		}
		return title;
	}
	
	
}
