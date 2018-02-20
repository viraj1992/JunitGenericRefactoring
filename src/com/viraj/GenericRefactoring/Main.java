package com.viraj.GenericRefactoring;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	
	WebDriver driver;
	String baseUrl;
	GenericMethod gm;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Viraj\\Desktop\\Selenium Drivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		gm = new GenericMethod(driver);
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		boolean result1 = gm.isElementPresent("name", "id");
		System.out.println("Is Element Present: " + result1);
		
		boolean result2 = gm.isElementPresent("name-not-present", "id");
		System.out.println("Is Element Present: " + result2);
	}


	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	
}
