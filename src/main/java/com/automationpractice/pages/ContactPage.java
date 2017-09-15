package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automationpractice.common.PageObject;

public class ContactPage extends PageObject {

	
	private By yourName = By.name("your-name");
	private By yourEmail = By.name("your-email");
	private By yourSubject = By.name("your-subject");
	private By yourMessage = By.name("your-message");
	private By sendBtn = By.cssSelector("input.wpcf7-form-control.wpcf7-submit[value=\"Send\"]");
	private By msgSentSuccessfully = By.cssSelector("div.wpcf7-response-output.wpcf7-display-none.wpcf7-mail-sent-ok[role=\"alert\"]");
	
	public ContactPage (WebDriver driver){
		super(driver);
	}
	
	
	//***** Contact page actions *****//
	
	
	public void typeYourName(String text) {
		
		typeText(yourName, text);
	}
	
	public void typeYourEmail(String text) {
		
		typeText(yourEmail, text);
	}
	
	public void typeSubject(String text) {
		
		typeText(yourSubject, text);
	}
	
	public void typeMessage(String text) {
		
		typeText(yourMessage, text);
	}
	
	public void clickSendBtn() {
		
		clickButton(sendBtn);
	}
	
	public String getMsgValue() {
		
		WebElement elm	= getElement(msgSentSuccessfully);
		return elm.getText();
	}

}
