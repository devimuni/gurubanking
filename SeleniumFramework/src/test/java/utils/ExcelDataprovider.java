package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataprovider {

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
		if((username.equalsIgnoreCase("mngr261116")) && (password.equalsIgnoreCase("JunUsud")))

		{	
			driver.findElement(By.name("btnLogin")).click();

			Thread.sleep(3000);
			String managerID= driver.findElement(By.xpath("//*[contains(text(),'Manger Id')]")).getText();

			System.out.println(managerID);

			if(managerID.equalsIgnoreCase("Manger Id : mngr261116")){ 

				System.out.println("Test passed"); 
				File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
				String fileName= "Result";
		  
				FileHandler.copy(file, new File("D:\\Selenium\\" + fileName + ".png"));
			} 
			else { System.out.println("Test failed2"); } 
			//Assert.assertEquals(managerID,"Manger Id : mngr261116");
			//System.out.println("Test Passed");
			

		}	
		else 
		{
			driver.findElement(By.name("btnLogin")).click();

			String txt = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();

			System.out.println(txt);

			if(txt.equalsIgnoreCase("User or Password is not valid")) 
			{

				System.out.println("Test failed");
				
			}
			else 
			{

				System.out.println("next step");
			}



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
