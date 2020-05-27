import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firefox {
	
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=  new FirefoxDriver();
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("test completed successfully");
		driver.close();

	}


}
