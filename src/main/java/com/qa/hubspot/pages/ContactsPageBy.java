package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.util.ElementActions;

public class ContactsPageBy {
	ElementActions elementActions ;
	By contactsPageHeader=By.xpath("//h1/i18n-string[text()='Contacts']");
	By createContactBtn=By.xpath("//span[text()='Create contact']");
	By createContactSecondBtn=By.xpath("//li//span[text()='Create contact']");
	By email=By.id("uid-ctrl-1");
	By firstName=By.id("uid-ctrl-2");
	By lastName=By.id("uid-ctrl-3");
	By jobTitle=By.id("uid-ctrl-5");
	WebDriver driver;
	
	public ContactsPageBy(WebDriver driver) {
		this.driver=driver;
		elementActions =new ElementActions(driver);
	}
	public boolean verifyContactsPageHeader() {
		
		return elementActions.contactHeaderIsDisplayed(contactsPageHeader);
	}
	public void createNewContact(String emailVal,String firstname,String lastname,String jobtitle) {
		elementActions.doClick(createContactBtn);
	    elementActions.doSendKeys(email, emailVal);
	    elementActions.doSendKeys(firstName, firstname);
	    elementActions.doSendKeys(lastName, lastname);
	    elementActions.doSendKeys(jobTitle, jobtitle);
		elementActions.doClick(createContactSecondBtn);
		

	}

}
