package com.bryntum.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.bryntum.po.HomePagePO;
import com.bryntum.po.LoginPagePO;

public class BaseTest implements DespatchConsoleConsts {
	
	public WebDriver driver = null;
	public static Actions actionTest = null;
	public static JavascriptExecutor js = null;
	
	public LoginPagePO loginPagePo = null;
	public HomePagePO homePagePo = null;
	
	public static String path = "";
	
	public BrowserType browser = BrowserType.CHROME;
	
	@BeforeTest
	public void initDriver() throws InterruptedException {
		
		if(browser==BrowserType.CHROME) {
			path = System.getProperty("user.dir")+"/resource/chromedriver";
			System.setProperty("webdriver.chrome.driver",path);
			driver = new ChromeDriver();	
		}
		else {
			path = System.getProperty("user.dir")+"/resource/geckodriver";
			System.setProperty("webdriver.gecko.driver",path);
			driver = new FirefoxDriver();
		}
		
		actionTest = new Actions(driver);
		js = (JavascriptExecutor)driver;
		
		driver.manage().window().maximize();
		driver.get(testUrl);
		
		loginPagePo = new LoginPagePO(driver);
		homePagePo = new HomePagePO(driver);
		
		Thread.sleep(15000);
		
	}
	
//	@AfterTest
//	public void closeDriver() {
//		driver.quit();
//	}
	

}
