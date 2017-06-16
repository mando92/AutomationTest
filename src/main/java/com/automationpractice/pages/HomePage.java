package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.common.PageObject;

public class HomePage extends PageObject {
	
	By registrationbtn = By.id("menu-item-374");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnRegistration()
	{
		clickButton(registrationbtn);
	}

}
