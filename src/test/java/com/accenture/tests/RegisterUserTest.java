package com.accenture.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.automationpractice.common.Person;
import com.automationpractice.common.TestDataHelper;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.RegistrationPage;
import com.automationpractice.common.BaseTest;

public class RegisterUserTest extends BaseTest{
	
	

	@BeforeTest
	public void beforeTest() {
		BaseTest bt = new BaseTest();
		bt.beforeTest();
	 
	}
	
	
	@Test
	public void registerUser() {
		
		TestDataHelper tdh = new TestDataHelper();
		Person p = tdh.getDataFromExcel(2);

		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnRegistration();
		
		
		
		RegistrationPage reg = new RegistrationPage(driver);
		reg.typefirstName(p.getFirstName());
		reg.typeLastName(p.getLastName());
		
		
		reg.checkStatus(tdh.chooseStatus(p.getStatus()));
		reg.checkHobby(tdh.chooseHobby(p.getHobby()));
		
		
		reg.selectCountry(Integer.parseInt(p.getCountry()));
		
		int[] mmddyyyy = tdh.splitDate(p.getDateOfBirth());
		reg.selectMonth(mmddyyyy[0]);
		reg.selectDay(mmddyyyy[1]);
		reg.selectYear(mmddyyyy[2]);
		
		
		reg.typePhoneNumber(p.getPhoneNumber());
		reg.typeUsername(p.getUserName());
		reg.typeEmail(p.getEmail());
		reg.typeDescription(p.getDescription());
		
		reg.typePassword(p.getPassword());
		reg.typeConfirmPassword(p.getPassword());
		
		
		reg.clickOnSubmit();
		
	}

	@AfterTest
	public void afterTest() {

		driver.quit();
	}

}
