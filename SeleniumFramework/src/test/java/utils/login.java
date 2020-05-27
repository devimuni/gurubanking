package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	
	
WebDriver driver;
	
	
	@BeforeTest
	public  void setupTest() {


		//System.setProperty("webdriver.chrome.silentOutput", "true");
		//System.setProperty("webdriver.chrome.driver","D:\\office\\softwares\\chrome1\\chromedriver_win32\\chromedriver.exe");

		//driver = new ChromeDriver();

		WebDriverManager.chromedriver().setup();

		System.setProperty("webdriver.chrome.silentOutput", "true");

		driver= new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();

		//driver=  new FirefoxDriver();
		
	}


	@Test(dataProvider = "test data")
	public void test1(String username, String password) throws InterruptedException, IOException {

		System.out.println(username+"  |  "+password);

		driver.get("http://www.demo.guru99.com/V4/");

		driver.manage().window().maximize();
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		if(isAlertPresent()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		
		}
		else
		{
			Assert.assertTrue(true);
			
			
			
		}
		
		
	}	
		
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e)
		{
		return false;	
		}
			
	}




	
	@AfterTest
	public  void closeTest() {


		driver.quit();



	}


	@DataProvider(name = "test data")
	public Object[][] getdata() {


		String excelPath = "D:\\Selenium\\SeleniumFramework\\excel\\testdata.xlsx";
		Object data[][] = testData(excelPath,"sheet1");

		return data;

	}



	public  Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getrowcount();
		int colCount = excel.getcolumncount();

		Object data [][] = new Object[rowCount-1][colCount];	
		for(int i=1; i<rowCount; i++) {
			for (int j=0; j<colCount;j++) {

				String cellData = excel.getcelldata(i, j);

				//System.out.print(cellData +"   ");

				data[i-1][j] = cellData;

			}
			//System.out.println();
		}
		return data;




	}


}
