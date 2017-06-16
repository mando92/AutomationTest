package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationpractice.common.PageObject;
import com.automationpractice.utils.Hobby;
import com.automationpractice.utils.Status;

public class RegistrationPage extends PageObject {
	
	private By firstNameTxt = By.id("name_3_firstname");
	private By lastNameTxt = By.id("name_3_lastname");
	private By singleStatusRadioBtn = By.cssSelector("input.input_fields.radio_fields[value=\"single\"]");
	private By marriedStatusRadioBtn = By.cssSelector("input.input_fields.radio_fields[value=\"married\"]");
	private By divorcedStatusRadioBtn = By.cssSelector("input.input_fields.radio_fields[value=\"divorced\"]");
	private By danceHobbyCheckBox = By.cssSelector("div.radio_wrap > input[value=\"dance\"]");
	private By cricketHobbyCheckBox = By.cssSelector("div.radio_wrap > input[value=\"cricket\"]");
	private By readingHobbyCheckBox = By.cssSelector("div.radio_wrap > input[value=\"reading\"]");
	
	private By countryDropdown = By.id("dropdown_7");
	private By monthDropdown = By.id("mm_date_8");
	private By dayDropdown = By.id("dd_date_8");
	private By yearDropdown = By.id("yy_date_8");
	private By phoneNumberTxt = By.id("phone_9");
	private By userNameTxt = By.id("username");
	private By emailTxt = By.id("email_1");
	
	private By pathTxt = By.id("profile_pic_10");
	private By descriptionTxt = By.id("description");
	private By passwordTxt = By.id("password_2");
	private By confirmPasswordTxt = By.id("confirm_password_password_2");
	private By progressBar = By.id("piereg_passwordStrength");  // Very Weak, Weak  Medium  Strong
	private By submitBtn = By.name("pie_submit");
	private By errorMessageTxt = By.cssSelector("span.legend error");
	

	public RegistrationPage(WebDriver driver) {		
		super(driver);
		
	}
	
	
	//***** Adding Registration page actions *****//

	public void typefirstName(String text)
	{
		typeText(firstNameTxt, text);
	}
	
	public void typeLastName(String text)
	{
		typeText(lastNameTxt, text);
	}
		
	public void checkStatus(Status s)
	{
		switch(s)
		{
		case SINGLE: clickButton(singleStatusRadioBtn);
		break;
		
		case DIVORCED: clickButton(divorcedStatusRadioBtn);
		break;
		
		case MARRIED: clickButton(marriedStatusRadioBtn);
		break;
		
		}
	}
	
	public void checkHobby(Hobby h)
	{
		switch(h)
		{
		case DANCE: clickButton(danceHobbyCheckBox);
		break;
		
		case CRICKET: clickButton(cricketHobbyCheckBox);
		break;
		
		case READING: clickButton(readingHobbyCheckBox);
		break;
		
		}
	}
	
	public void selectCountry(int country)
	{
		selectOptionByIndex(countryDropdown, country);
	}
	
	public void selectMonth(int month)
	{
		selectOptionByIndex(monthDropdown, month);
	}
	
	public void selectDay(int day)
	{
		selectOptionByIndex(dayDropdown, day);
	}
	
	public void selectYear(int year)
	{
		selectOptionByValue(yearDropdown, String.valueOf(year));
	}
	
	public void typePhoneNumber(String text)
	{
		typeText(phoneNumberTxt, text);
	}
	
	public void typeUsername(String text)
	{
		typeText(userNameTxt, text);
	}
	
	public void typeEmail(String text)
	{
		typeText(emailTxt, text);
	}
	
	public void typeDescription(String text)
	{
		typeText(descriptionTxt, text);
	}
	
	public void clickToAddPicture()
	{
		clickButton(pathTxt);
	}

	public void typePassword(String text)
	{
		typeText(passwordTxt, text);
	}
	
	public void typeConfirmPassword(String text)
	{
		typeText(confirmPasswordTxt, text);	
	}
	
	public void clickOnSubmit(){
		clickButton(submitBtn);
	}
	
	public String getPasswordStrength()
	{		
		return getElement(progressBar).getText();
	}


}
