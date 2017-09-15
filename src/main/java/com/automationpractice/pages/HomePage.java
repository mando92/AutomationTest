package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.common.PageObject;

public class HomePage extends PageObject {
	
	By registrationBtn = By.id("menu-item-374");
	By contactBtn = By.id("menu-item-64");

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickOnRegistration() {
		clickButton(registrationBtn);
	}
	
	public void clickOnContact() {
		
		clickButton(contactBtn);
	}

}
