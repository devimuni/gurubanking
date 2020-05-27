import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class browsertestwebdriverjar {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("test completed successfully");
		driver.close();
		
		
		
	}

}
