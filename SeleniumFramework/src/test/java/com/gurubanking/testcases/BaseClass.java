package com.gurubanking.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.gurubanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username= readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	
	
	WebDriver driver;
			
	@BeforeTest
	public  void setupTest() {

		WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.silentOutput", "true");

		driver= new ChromeDriver();
	}

	
	@AfterTest
	public  void closeTest() {

		driver.quit();
		
	}

}
