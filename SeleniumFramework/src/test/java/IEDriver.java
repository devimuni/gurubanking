import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDriver {

	public static void main(String[] args) {

		WebDriverManager.iedriver().setup();	
		WebDriver driver= new InternetExplorerDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("test completed successfully");
		driver.close();

	}

}
