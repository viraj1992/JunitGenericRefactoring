package com.viraj.GenericRefactoring;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethod {
	
	WebDriver driver;
	// Created Constructor
	
	public GenericMethod(WebDriver driver) {
		this.driver = driver;
	}
	
	public List<WebElement> getElements(String locator, String type){
		type = type.toLowerCase();
		List<WebElement> elementList = new ArrayList<WebElement>();
		if(type.equals("id")){
			elementList = driver.findElements(By.id(locator));
		} else if(type.equals("xpath")){
			elementList = driver.findElements(By.xpath(locator));
		} else
			 System.out.println("Locator Type not supported!");	
		if(elementList.isEmpty()) {
			System.out.println("Element not found with " + type + " : " + locator);
		} else 
			System.out.println("Element found with " + type + " : " + locator);
		return elementList;
	}
	

	// Check if the element is present on the web page

	public boolean isElementPresent(String locator, String type) {
		type = type.toLowerCase();
		List<WebElement> elementList = getElements(locator, type);
		if(elementList.size() > 0){
			return true;
		}	else 
			return false;
	}

}
