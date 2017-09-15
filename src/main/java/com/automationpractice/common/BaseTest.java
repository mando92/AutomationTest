package com.automationpractice.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static WebDriver driver;
	
	public void beforeTest() {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/luis.garza/git/AutomationTest/srcDriver/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demoqa.com/");
	}
	
	
	
	public void afterTest() {

		driver.quit();
	}
}
