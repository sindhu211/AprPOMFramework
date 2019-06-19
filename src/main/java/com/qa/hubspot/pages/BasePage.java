package com.qa.hubspot.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author mgova
 *
 */
public class BasePage {
	public static WebDriver driver;
	public Properties prop;
	/**
	 * 
	 * @param prop
	 * @return this method will return driver on the basis of properties
	 */
	public WebDriver init_driver(Properties prop) {
	String browser=prop.getProperty("browser");
	if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","E:\\New folder (2)\\chromedriver.exe"); 
	      driver=new ChromeDriver();
	     
	}
	else if(browser.equals("ff")){
		System.setProperty("webdriver.gecko.driver","E:\\New folder (2)\\geckodriver.exe"); 
	      driver=new FirefoxDriver();
	}
	else {
		System.out.println(browser+"---> no browser is defined");
	}
	driver.manage().window().fullscreen();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtimeout")), TimeUnit.SECONDS);
	return driver;
	}
	public Properties init_prop() throws IOException {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:/Users/mgova/eclipse-workspace/AprPOMFramework/src/main/java/com/qa/hubspot/config/config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
