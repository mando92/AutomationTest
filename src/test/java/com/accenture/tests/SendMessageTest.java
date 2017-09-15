package com.accenture.tests;


import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import com.automationpractice.common.BaseTest;
import com.automationpractice.common.OutputToExcel;
import com.automationpractice.common.Person;
import com.automationpractice.common.ReadExcel;
import com.automationpractice.common.TestDataHelper;
import com.automationpractice.pages.ContactPage;
import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.RegistrationPage;


public class SendMessageTest extends BaseTest{

	BaseTest bt = new BaseTest();
	TestDataHelper tdh = new TestDataHelper();
	Person p = tdh.getDataForMessage(4);
	TestDataHelper tdh2 = new TestDataHelper();
	OutputToExcel ote = new OutputToExcel();
	
	@BeforeTest
	public void beforeTest() {
		bt.beforeTest();
	}
	
	@Test
	public void sendMessage() throws IOException {
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnContact();
		
		ContactPage cp = new ContactPage(driver);
		cp.typeYourName(p.getFirstName()+" "+p.getLastName());
		cp.typeSubject(p.getSubject());
		cp.typeYourEmail(p.getEmail());
		cp.typeMessage(p.getMessage());
		cp.clickSendBtn();
		Assert.assertEquals("Your message was sent successfully. Thanks.", cp.getMsgValue());
		String title = driver.getTitle();
		String resultx = driver.getCurrentUrl();
		ArrayList<String> tr = new ArrayList<String>();
		tr.add(title);
		tr.add(resultx);
		ote.newOutputResults(tr);
		
	}
	
	@AfterTest
	public void stopDriver() {
		bt.afterTest();
	}
}
