package com.automationpractice.common;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class PageObject {
	
	final protected WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void typeText(By element, String text){
		
		getElement(element).clear();
		getElement(element).sendKeys(text);
		
	}
	
	
	public void clickButton(By element)
	{
		getElement(element).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void selectOptionByIndex(By element, int index)
	{
		Select optionSelect = new Select(getElement(element));
		optionSelect.selectByIndex(index);

	}
	
	public void selectOptionByValue(By element, String value)
	{
		Select optionSelect = new Select(getElement(element));
		optionSelect.selectByValue(value);

	}
	
	
	public WebElement getElement(By element)
	{
		return driver.findElement(element);
		
	}
	
	
	

}
