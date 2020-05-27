import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testngdemo {
	WebDriver driver =null;
	
	@BeforeTest
	public void setuptest()
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	
	@Test
	public void googletitle() 
	{
	driver.get("https://www.google.com/");
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	}
	
	@AfterTest
	public void googleclose()
	{
	System.out.println("test completed successfully");
	driver.close();
	}
	
	
	
	

}
